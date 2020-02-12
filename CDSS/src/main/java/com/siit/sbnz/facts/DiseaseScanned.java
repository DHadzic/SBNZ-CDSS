package com.siit.sbnz.facts;

public class DiseaseScanned {
	private String diseaseId;
	private String patient;
	private Integer symptomNum;
	
	

	public String getDiseaseId() {
		return diseaseId;
	}
	public void setDiseaseId(String diseaseId) {
		this.diseaseId = diseaseId;
	}
	public String getPatient() {
		return patient;
	}
	public void setPatient(String patient) {
		this.patient = patient;
	}
	public Integer getSymptomNum() {
		return symptomNum;
	}
	public void setSymptomNum(Integer symptomNum) {
		this.symptomNum = symptomNum;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diseaseId == null) ? 0 : diseaseId.hashCode());
		result = prime * result + ((patient == null) ? 0 : patient.hashCode());
		result = prime * result + ((symptomNum == null) ? 0 : symptomNum.hashCode());
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
		DiseaseScanned other = (DiseaseScanned) obj;
		if (diseaseId == null) {
			if (other.diseaseId != null)
				return false;
		} else if (!diseaseId.equals(other.diseaseId))
			return false;
		if (patient == null) {
			if (other.patient != null)
				return false;
		} else if (!patient.equals(other.patient))
			return false;
		if (symptomNum == null) {
			if (other.symptomNum != null)
				return false;
		} else if (!symptomNum.equals(other.symptomNum))
			return false;
		return true;
	}
}
