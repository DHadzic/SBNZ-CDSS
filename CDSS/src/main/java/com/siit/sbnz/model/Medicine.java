package com.siit.sbnz.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;	
    @Column
    private String medicineId;
    @ElementCollection
	private List<String> supstances;
	
	public Medicine() {
		supstances = new ArrayList<String>();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<String> getSupstances() {
		return supstances;
	}
	public void setSupstances(List<String> supstances) {
		this.supstances = supstances;
	}

	public String getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(String medicineId) {
		this.medicineId = medicineId;
	}
	public void changeSupstance(String oldSup,String newSup) {
		for(int i = 0; i < supstances.size() ; i++) {
			if( supstances.get(i).equals(oldSup)) supstances.set(i, newSup);
		}
	}
}
