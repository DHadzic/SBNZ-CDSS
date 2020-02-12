package com.siit.sbnz.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siit.sbnz.facts.FactSymptom;
import com.siit.sbnz.model.Diagnose;

@Service
public class DoctorService {
	
	@Autowired
	KieContainer container;

	public String test() {
		KieSession session = container.newKieSession("CdssSession");
		
		session.insert(new FactSymptom("simptom1","jmbg1","bolest1","jedan"));
		session.insert(new FactSymptom("simptom2","jmbg1","bolest1","jedan"));
		session.insert(new FactSymptom("simptom3","jmbg1","bolest1","jedan"));
		session.insert(new FactSymptom("simptom4","jmbg1","bolest1","jedan"));
		
		session.fireAllRules();
		
		for (Object obj : session.getObjects()) {
			if(obj instanceof Diagnose) {
				System.out.println(((Diagnose)obj).toString());
			}
		}
		
		return "";
	}
	
}
