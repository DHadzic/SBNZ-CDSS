package com.siit.sbnz.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.siit.sbnz.DTOs.LoginDTO;
import com.siit.sbnz.DTOs.TokenDTO;
import com.siit.sbnz.DTOs.UserDTO;
import com.siit.sbnz.model.User;
import com.siit.sbnz.security.ForbiddenException;
import com.siit.sbnz.security.JWTUtils;
import com.siit.sbnz.service.UserService;

@RestController
@RequestMapping("api")
public class UserController {
	
    @Autowired
    private JWTUtils jwtUtils;

    @Autowired
    private UserService userService;
    
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;
	
    @RequestMapping(
            value = "/login",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity login(@Valid @RequestBody LoginDTO loginDTO, BindingResult errors) {
        try {
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                    loginDTO.getUsername(), loginDTO.getPassword());
            authenticationManager.authenticate(token);

            UserDetails details = userDetailsService.loadUserByUsername(loginDTO.getUsername());
            User user = userService.getUser(loginDTO.getUsername());
            Long id = user.getId();
            TokenDTO userToken = new TokenDTO(jwtUtils.generateToken(details, id));
            return new ResponseEntity<>(userToken, HttpStatus.OK);
        } catch(ForbiddenException ex) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
    
    @RequestMapping(
    		value = "/register",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity register(@RequestBody UserDTO user) {
    	return new ResponseEntity<String>(userService.registerUser(user),HttpStatus.OK);
    }

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(
    		value = "/delete/{username}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity register(@PathVariable String username) {
    	return new ResponseEntity<String>(userService.removeUser(username),HttpStatus.OK);
    }    

}
