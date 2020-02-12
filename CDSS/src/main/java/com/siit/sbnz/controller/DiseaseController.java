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

import com.siit.sbnz.DTOs.DiseaseDTO;
import com.siit.sbnz.model.Disease;
import com.siit.sbnz.service.DiseaseService;

@RestController
@CrossOrigin(value = "http://localhost:4200")
@RequestMapping("api/disease")
public class DiseaseController {
	
	@Autowired
	DiseaseService diseaseService;
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(
    		value = "",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addDisease(@RequestBody Disease disease) {
    	return new ResponseEntity<String>(diseaseService.save(disease),HttpStatus.OK);
    }
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(
    		value = "",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editDisease(@RequestBody DiseaseDTO disease) {
    	return new ResponseEntity<String>(diseaseService.edit(disease),HttpStatus.OK);
    }

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(
    		value = "/{diseaseId}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteDisease(@PathVariable String diseaseId) {
    	return new ResponseEntity<String>(diseaseService.remove(diseaseId),HttpStatus.OK);
    }
}
