package com.siit.sbnz.model;

import java.util.ArrayList;
import java.util.Date;

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
    @Column
    private ArrayList<String> symptomsFound;
    @Column
    private Date diagnoseDate;
    
    public Diagnose() {}
    
	public Diagnose(String patientJmbg, String diagnosedDisease, String givenMedicine, ArrayList<String> symptomsFound,
			Date diagnoseDate) {
		super();
		this.patientJmbg = patientJmbg;
		this.diagnosedDisease = diagnosedDisease;
		this.givenMedicine = givenMedicine;
		this.symptomsFound = symptomsFound;
		this.diagnoseDate = diagnoseDate;
	}




	public Date getDiagnoseDate() {
		return diagnoseDate;
	}


	public void setDiagnoseDate(Date diagnoseDate) {
		this.diagnoseDate = diagnoseDate;
	}


	public void setSymptomsFound(ArrayList<String> symptomsFound) {
		this.symptomsFound = symptomsFound;
	}


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


	public ArrayList<String> getSymptomsFound() {
		return symptomsFound;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diagnoseDate == null) ? 0 : diagnoseDate.hashCode());
		result = prime * result + ((diagnosedDisease == null) ? 0 : diagnosedDisease.hashCode());
		result = prime * result + ((givenMedicine == null) ? 0 : givenMedicine.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((patientJmbg == null) ? 0 : patientJmbg.hashCode());
		result = prime * result + ((symptomsFound == null) ? 0 : symptomsFound.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Diagnose other = (Diagnose) obj;
		if (diagnoseDate == null) {
			if (other.diagnoseDate != null)
				return false;
		} else if (!diagnoseDate.equals(other.diagnoseDate))
			return false;
		if (diagnosedDisease == null) {
			if (other.diagnosedDisease != null)
				return false;
		} else if (!diagnosedDisease.equals(other.diagnosedDisease))
			return false;
		if (givenMedicine == null) {
			if (other.givenMedicine != null)
				return false;
		} else if (!givenMedicine.equals(other.givenMedicine))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (patientJmbg == null) {
			if (other.patientJmbg != null)
				return false;
		} else if (!patientJmbg.equals(other.patientJmbg))
			return false;
		if (symptomsFound == null) {
			if (other.symptomsFound != null)
				return false;
		} else if (!symptomsFound.equals(other.symptomsFound))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Diagnose [patientJmbg=" + patientJmbg + ", diagnosedDisease=" + diagnosedDisease + ", symptomsFound="
				+ symptomsFound + "]";
	}
	
	
}
