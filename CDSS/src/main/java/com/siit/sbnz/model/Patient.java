package com.siit.sbnz.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @Column
    private String jmbg;
    @ElementCollection
    private ArrayList<String> allergies;
    
    public Patient() {
    	allergies = new ArrayList<String>();
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	public ArrayList<String> getAllergies() {
		return allergies;
	}
	public void setAllergies(ArrayList<String> allergies) {
		this.allergies = allergies;
	}
	public void changeAllergy(String oldAll,String newAll) {
		for(int i = 0; i < allergies.size() ; i++) {
			if( allergies.get(i).equals(oldAll)) allergies.set(i, newAll);
		}
	}
}
