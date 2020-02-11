package com.siit.sbnz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siit.sbnz.model.Medicine;
import com.siit.sbnz.repository.MedicineRepository;
import com.siit.sbnz.repository.SupstanceRepository;

@Service
public class MedicineService {

	@Autowired
	MedicineRepository medicineRep;

	@Autowired
	SupstanceRepository supstanceRep;

	public String save(Medicine medicine) {
		if(medicineRep.findByMedicineId(medicine.getMedicineId()) != null) return "Invalid data";
		for (String sup : medicine.getSupstances()) {
			if(supstanceRep.findBySupstanceId(sup) == null) return "Invalid data";
		}
		medicine.setId(null);
		medicineRep.save(medicine);
		return "Successful";
	}
	
	public String edit(String oldId,Medicine medicine) {
		if(medicineRep.findByMedicineId(oldId) == null) return "Invalid data"; 
		Medicine med = medicineRep.findByMedicineId(oldId);
		med.setMedicineId(medicine.getMedicineId());
		for (String supstance : medicine.getSupstances()) {
			if(supstanceRep.findBySupstanceId(supstance) == null) return "Invalid data";
		}
		med.setSupstances(medicine.getSupstances());
		medicineRep.save(med);
		return "Successful";
	}
	
	public String remove(String medicineId) {
		if(medicineRep.findByMedicineId(medicineId) == null) return "Invalid Data";
		medicineRep.delete(medicineRep.findByMedicineId(medicineId));
		return "Successful";
	}
}
