package com.siit.sbnz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.siit.sbnz.DTOs.SupstanceDTO;
import com.siit.sbnz.service.SupstanceService;

@RestController
@CrossOrigin(value = "http://localhost:4200")
@RequestMapping("api/supstance")
public class SupstanceController {

	@Autowired
	SupstanceService supstanceService;
	
    @RequestMapping(
    		value = "/{supstanceId}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addSupstance(@PathVariable String supstanceId) {
    	return new ResponseEntity<String>(supstanceService.save(supstanceId),HttpStatus.OK);
    }
	
    @RequestMapping(
    		value = "",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editSupstance(@RequestBody SupstanceDTO supstance) {
    	return new ResponseEntity<String>(supstanceService.edit(supstance),HttpStatus.OK);
    }

    @RequestMapping(
    		value = "/{supstanceId}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteSupstance(@PathVariable String supstanceId) {
    	return new ResponseEntity<String>(supstanceService.remove(supstanceId),HttpStatus.OK);
    }
}
