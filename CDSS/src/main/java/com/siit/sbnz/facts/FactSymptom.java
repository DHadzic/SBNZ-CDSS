package com.siit.sbnz.facts;

import java.io.Serializable;

public class FactSymptom implements Serializable {
    private static final long serialVersionUID = 1L;
    private String symptomId;
    private String patient;
    private String disease;
    private String group;
    private boolean fired;
    
    public FactSymptom () {}
    
	public FactSymptom(String symptomId, String patient, String disease,String group) {
		super();
		this.symptomId = symptomId;
		this.patient = patient;
		this.disease = disease;
		this.group = group;
		this.fired = false;
	}


	public String getSymptomId() {
		return symptomId;
	}
	public void setSymptomId(String symptomId) {
		this.symptomId = symptomId;
	}
	public String getPatient() {
		return patient;
	}
	public void setPatient(String patient) {
		this.patient = patient;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public boolean isFired() {
		return fired;
	}

	public void setFired(boolean fired) {
		this.fired = fired;
	}
	
	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disease == null) ? 0 : disease.hashCode());
		result = prime * result + (fired ? 1231 : 1237);
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
		FactSymptom other = (FactSymptom) obj;
		if (disease == null) {
			if (other.disease != null)
				return false;
		} else if (!disease.equals(other.disease))
			return false;
		if (fired != other.fired)
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
		return "FactSymptom [symptomId=" + symptomId + ", patient=" + patient + ", disease=" + disease + ", fired="
				+ fired + "]";
	}
	
}
