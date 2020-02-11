package com.siit.sbnz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.siit.sbnz.model.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Long>{
	Medicine findByMedicineId(String medicineId);
}
