package com.siit.sbnz.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Symptom implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;	

    @Column
	private String symptomId;
    
    private String patient;
    
    @Column
	private String disease;
    
    public Symptom() {
    	
    }

    public Symptom(String symptomId, String patient, String disease) {
		super();
		this.symptomId = symptomId;
		this.patient = patient;
		this.disease = disease;
	}
    
	public Symptom(Long id, String symptomId, String patient, String disease) {
		this.id = id;
		this.symptomId = symptomId;
		this.patient = patient;
		this.disease = disease;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSymptomId() {
		return symptomId;
	}
	public void setSymptomId(String symptomId) {
		this.symptomId = symptomId;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getPatient() {
		return patient;
	}
	public void setPatient(String patient) {
		this.patient = patient;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disease == null) ? 0 : disease.hashCode());
		result = prime * result + ((patient == null) ? 0 : patient.hashCode());
		result = prime * result + ((symptomId == null) ? 0 : symptomId.hashCode());
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
		Symptom other = (Symptom) obj;
		if (disease == null) {
			if (other.disease != null)
				return false;
		} else if (!disease.equals(other.disease))
			return false;
		if (patient == null) {
			if (other.patient != null)
				return false;
		} else if (!patient.equals(other.patient))
			return false;
		if (symptomId == null) {
			if (other.symptomId != null)
				return false;
		} else if (!symptomId.equals(other.symptomId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Symptom [symptomId=" + symptomId + ", patient=" + patient + ", disease=" + disease + "]";
	}
	
}
