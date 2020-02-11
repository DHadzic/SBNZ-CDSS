package com.siit.sbnz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siit.sbnz.model.Patient;
import com.siit.sbnz.model.Symptom;
import com.siit.sbnz.repository.PatientRepository;
import com.siit.sbnz.repository.SupstanceRepository;

@Service
public class PatientService {
	@Autowired
	PatientRepository patientRep;
	
	@Autowired
	SupstanceRepository supstanceRep;
	
	public String save(Patient patient) {
		if(patientRep.findByJmbg(patient.getJmbg()) != null) return "Invalid data";
		for (String supstance : patient.getAllergies()) {
			if(supstanceRep.findBySupstanceId(supstance)==null) return "Invalid data";
		}
		patient.setId(null);
		patientRep.save(patient);
		return "Successful";
	}
	
	public String edit(Patient patient) {
		if(patientRep.findByJmbg(patient.getJmbg()) == null) return "Invalid data"; 
		Patient pat = patientRep.findByJmbg(patient.getJmbg());
		for (String supstance : pat.getAllergies()) {
			if(supstanceRep.findBySupstanceId(supstance) == null) return "Invalid data";
		}
		pat.setAllergies(patient.getAllergies());
		patientRep.save(pat);
		return "Successful";
	}
	
	public String remove(String patientId) {
		if(patientRep.findByJmbg(patientId) == null) return "Invalid Data";
		patientRep.delete(patientRep.findByJmbg(patientId));
		return "Successful";
	}

}
