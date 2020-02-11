package com.siit.sbnz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siit.sbnz.model.Supstance;

public interface SupstanceRepository extends JpaRepository<Supstance, Long>{
	Supstance findBySupstanceId(String supstanceId);
}
