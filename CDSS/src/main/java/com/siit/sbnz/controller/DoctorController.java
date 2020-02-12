package com.siit.sbnz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.siit.sbnz.service.DoctorService;

@RestController
@CrossOrigin(value = "http://localhost:4200")
@RequestMapping("api/doctor")
public class DoctorController {

	@Autowired
	DoctorService doctorService;
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(
    		value = "",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity testRules() {
    	return new ResponseEntity<String>(doctorService.test(),HttpStatus.OK);
    }

}
