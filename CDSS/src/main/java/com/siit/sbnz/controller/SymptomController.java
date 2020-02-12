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

import com.siit.sbnz.model.Symptom;
import com.siit.sbnz.service.SymptomService;

@RestController
@CrossOrigin(value = "http://localhost:4200")
@RequestMapping("api/symptom")
public class SymptomController {

	@Autowired
	SymptomService symptomService;
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(
    		value = "",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addSymptom(@RequestBody Symptom symptom) {
    	return new ResponseEntity<String>(symptomService.save(symptom),HttpStatus.OK);
    }
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(
    		value = "/{symptomId}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editSymptom(@PathVariable String symptomId,@RequestBody Symptom symptom) {
    	return new ResponseEntity<String>(symptomService.edit(symptomId,symptom),HttpStatus.OK);
    }

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(
    		value = "/{symptomId}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteSymptom(@PathVariable String symptomId) {
    	return new ResponseEntity<String>(symptomService.remove(symptomId),HttpStatus.OK);
    }
}
