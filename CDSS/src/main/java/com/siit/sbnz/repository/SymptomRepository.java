package com.siit.sbnz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siit.sbnz.model.Symptom;

public interface SymptomRepository extends JpaRepository<Symptom, Long>{
	List<Symptom> findBySymptomId(String symptomId);
	List<Symptom> findByDisease(String disease);
}
