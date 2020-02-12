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

import com.siit.sbnz.model.Medicine;
import com.siit.sbnz.service.MedicineService;

@RestController
@CrossOrigin(value = "http://localhost:4200")
@RequestMapping("api/medicine")
public class MedicineController {
	@Autowired
	MedicineService medicineService;
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(
    		value = "",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addMedicine(@RequestBody Medicine medicine) {
    	return new ResponseEntity<String>(medicineService.save(medicine),HttpStatus.OK);
    }
	
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(
    		value = "/{medicineId}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editMedicine(@PathVariable String medicineId,@RequestBody Medicine medicine) {
    	return new ResponseEntity<String>(medicineService.edit(medicineId,medicine),HttpStatus.OK);
    }

	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @RequestMapping(
    		value = "/{medicineId}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deleteMedicine(@PathVariable String medicineId) {
    	return new ResponseEntity<String>(medicineService.remove(medicineId),HttpStatus.OK);
    }

}
