package com.siit.sbnz.facts;

import java.util.ArrayList;
import java.util.Date;

public class DiagnoseGiven {
	private String diseaseId;
	private String patient;
	private ArrayList<String> symptoms;
	private String medicineId;
	private Date diagnoseDate;
	public DiagnoseGiven() {
		
	}
	
	public DiagnoseGiven(String diseaseId, String patient, ArrayList<String> symptoms, String medicineId,
			Date diagnoseDate) {
		super();
		this.diseaseId = diseaseId;
		this.patient = patient;
		this.symptoms = symptoms;
		this.medicineId = medicineId;
		this.diagnoseDate = diagnoseDate;
	}

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
	public ArrayList<String> getSymptoms() {
		return symptoms;
	}
	public void setSymptoms(ArrayList<String> symptoms) {
		this.symptoms = symptoms;
	}
	public String getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(String medicineId) {
		this.medicineId = medicineId;
	}
	public Date getDiagnoseDate() {
		return diagnoseDate;
	}
	public void setDiagnoseDate(Date diagnoseDate) {
		this.diagnoseDate = diagnoseDate;
	}

	@Override
	public String toString() {
		return "DiagnoseGiven [diseaseId=" + diseaseId + ", patient=" + patient + ", symptoms=" + symptoms
				+ ", medicineId=" + medicineId + ", diagnoseDate=" + diagnoseDate + "]";
	}
}
