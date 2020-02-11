package com.siit.sbnz.service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siit.sbnz.DTOs.SupstanceDTO;
import com.siit.sbnz.model.Medicine;
import com.siit.sbnz.model.Patient;
import com.siit.sbnz.model.Supstance;
import com.siit.sbnz.repository.MedicineRepository;
import com.siit.sbnz.repository.PatientRepository;
import com.siit.sbnz.repository.SupstanceRepository;

@Service
public class SupstanceService {

	@Autowired
	SupstanceRepository supstanceRep;
	
	@Autowired
	MedicineRepository medicineRep;
	
	@Autowired
	PatientRepository patientRep;

	public String save(String supstanceId) {
		if(supstanceRep.findBySupstanceId(supstanceId) != null) return "Invalid data";
		Supstance supstance = new Supstance();
		supstance.setSupstanceId(supstanceId);
		supstanceRep.save(supstance);
		return "Successful";
	}
	
	public String edit(SupstanceDTO supstanceDTO) {
		if(supstanceRep.findBySupstanceId(supstanceDTO.getOldId()) == null) return "Invalid data"; 
		Supstance supstance = supstanceRep.findBySupstanceId(supstanceDTO.getOldId());
		supstance.setSupstanceId(supstanceDTO.getNewId());
		for (Medicine med : medicineRep.findAll()) {
			med.changeSupstance(supstanceDTO.getOldId(), supstanceDTO.getNewId());
			medicineRep.save(med);
		}
		for (Patient pat : patientRep.findAll()) {
			pat.changeAllergy(supstanceDTO.getOldId(), supstanceDTO.getNewId());
			patientRep.save(pat);
		}
		supstanceRep.save(supstance);
		return "Successful";
	}
	
	public String remove(String supstanceId) {
		if(supstanceRep.findBySupstanceId(supstanceId) == null) return "Invalid Data";
		supstanceRep.delete(supstanceRep.findBySupstanceId(supstanceId));
		Iterator<String> iter = null;
		for (Medicine med : medicineRep.findAll()) {
			iter = med.getSupstances().iterator();
			while(iter.hasNext()) {
				if(iter.next().equals(supstanceId)) iter.remove();
			}
		}
		for (Patient pat : patientRep.findAll()) {
			iter = pat.getAllergies().iterator();
			while(iter.hasNext()) {
				if(iter.next().equals(supstanceId)) iter.remove();
			}
		}
		return "Successful";
	}
}
