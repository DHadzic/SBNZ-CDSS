package com.siit.sbnz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siit.sbnz.model.Disease;

public interface DiseaseRepository extends JpaRepository<Disease, Long>{
	Disease findByDiseaseId(String diseaseId);
}
