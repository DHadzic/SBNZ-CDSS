package com.siit.sbnz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.siit.sbnz.DTOs.UserDTO;
import com.siit.sbnz.model.User;
import com.siit.sbnz.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRep;
	
	
	public User getUser(String username) {
		return userRep.findByUsername(username);
	}
	
	public List<User> getAll(String username){
		return userRep.findAll();
	}
	
	public String registerUser(UserDTO userDTO) {
		User user = new User();
		if(userRep.findByUsername(userDTO.getUsername()) != null) { return "Username taken"; }
		user.setUsername(userDTO.getUsername());
    	BCryptPasswordEncoder coder = new BCryptPasswordEncoder();
		user.setPassword(coder.encode(userDTO.getPassword()));
		if(userDTO.getRole().equals("ROLE_ADMIN")) {
			user.setRole("ROLE_ADMIN");
		}else if (userDTO.getRole().equals("ROLE_DOCTOR")) {
			user.setRole("ROLE_DOCTOR");
		}else {
			return "Invalid user data";
		}
		
		userRep.save(user);
		return "Successful";
	}
	
	public String removeUser(String username) {
		User user = userRep.findByUsername(username);
		if(user != null) { return "Username non existent"; }
		userRep.delete(user);
		return "Successful";
	}

}
