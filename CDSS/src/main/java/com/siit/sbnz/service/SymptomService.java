package com.siit.sbnz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siit.sbnz.model.Symptom;
import com.siit.sbnz.repository.DiseaseRepository;
import com.siit.sbnz.repository.SymptomRepository;

@Service
public class SymptomService {

	@Autowired
	SymptomRepository symptomRep;
	
	@Autowired
	DiseaseRepository diseaseRep;
	
	public String save(Symptom symptom) {
		if(symptomRep.findBySymptomId(symptom.getSymptomId()).size() != 0) return "Invalid data";
		if(diseaseRep.findByDiseaseId(symptom.getDisease()) == null) return "Invalid data";
		symptomRep.save(symptom);
		return "Successful";
	}
	
	public String edit(String symptomId, Symptom newSym) {
		if(symptomRep.findBySymptomId(symptomId).size() == 0) return "Invalid data"; 
		if(diseaseRep.findByDiseaseId(newSym.getDisease()) == null) return "Invalid data";
		for (Symptom sym : symptomRep.findBySymptomId(symptomId)) {
			sym.setDisease(newSym.getDisease());
			sym.setSymptomId(newSym.getSymptomId());
			symptomRep.save(sym);			
		}
		
		return "Successful";
	}
	
	public String remove(String symptomId) {
		if(symptomRep.findBySymptomId(symptomId).size() == 0) return "Invalid Data";
		for (Symptom sym : symptomRep.findBySymptomId(symptomId)) {
			symptomRep.delete(sym);
		}
		return "Successful";
	}
}
