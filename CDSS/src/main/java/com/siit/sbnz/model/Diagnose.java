package com.siit.sbnz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Diagnose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column
    private String patientJmbg;
    @Column
    private String diagnosedDisease;
    @Column
    private String givenMedicine;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPatientJmbg() {
		return patientJmbg;
	}
	public void setPatientJmbg(String patientJmbg) {
		this.patientJmbg = patientJmbg;
	}
	public String getDiagnosedDisease() {
		return diagnosedDisease;
	}
	public void setDiagnosedDisease(String diagnosedDisease) {
		this.diagnosedDisease = diagnosedDisease;
	}
	public String getGivenMedicine() {
		return givenMedicine;
	}
	public void setGivenMedicine(String givenMedicine) {
		this.givenMedicine = givenMedicine;
	}
}
