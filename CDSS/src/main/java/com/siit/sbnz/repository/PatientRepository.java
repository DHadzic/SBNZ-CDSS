package com.siit.sbnz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siit.sbnz.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{
	Patient findByJmbg(String jmbg);
}
