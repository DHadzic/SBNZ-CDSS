package com.siit.sbnz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.siit.sbnz.model.Patient;
import com.siit.sbnz.service.PatientService;


@RestController
@CrossOrigin(value = "http://localhost:4200")
@RequestMapping("api/patient")
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(
    		value = "",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addPatient(@RequestBody Patient patient) {
    	return new ResponseEntity<String>(patientService.save(patient),HttpStatus.OK);
    }
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(
    		value = "/{patientId}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editPatient(@RequestBody Patient patient) {
    	return new ResponseEntity<String>(patientService.edit(patient),HttpStatus.OK);
    }

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(
    		value = "/{patientId}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deletePatient(@PathVariable String patientId) {
    	return new ResponseEntity<String>(patientService.remove(patientId),HttpStatus.OK);
    }
}
