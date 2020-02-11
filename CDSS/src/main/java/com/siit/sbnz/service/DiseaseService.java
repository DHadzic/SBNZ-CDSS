package com.siit.sbnz.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siit.sbnz.DTOs.DiseaseDTO;
import com.siit.sbnz.model.Disease;
import com.siit.sbnz.model.Symptom;
import com.siit.sbnz.repository.DiseaseRepository;
import com.siit.sbnz.repository.SymptomRepository;

@Service
public class DiseaseService {
	
	@Autowired
	DiseaseRepository diseaseRep;
	
	@Autowired
	SymptomRepository symptomRep;
	
	public String save(String diseaseId) {
		if(diseaseRep.findByDiseaseId(diseaseId) != null) return "Invalid data";
		Disease disease = new Disease();
		disease.setDiseaseId(diseaseId);
		diseaseRep.save(disease);
		return "Successful";
	}
	
	public String edit(DiseaseDTO diseaseDTO) {
		if(diseaseRep.findByDiseaseId(diseaseDTO.getOldId()) == null) return "Invalid data"; 
		Disease disease = diseaseRep.findByDiseaseId(diseaseDTO.getOldId());
		disease.setDiseaseId(diseaseDTO.getNewId());
		for (Symptom symptom : symptomRep.findByDisease(diseaseDTO.getOldId())) {
			symptom.setDisease(diseaseDTO.getNewId());
			symptomRep.delete(symptom);
		}
		diseaseRep.save(disease);
		return "Successful";
	}
	
	public String remove(String diseaseId) {
		if(diseaseRep.findByDiseaseId(diseaseId) == null) return "Invalid Data";
		diseaseRep.delete(diseaseRep.findByDiseaseId(diseaseId));
		for (Symptom symptom : symptomRep.findByDisease(diseaseId)) {
			symptomRep.delete(symptom);
		}
		return "Successful";
	}

}
