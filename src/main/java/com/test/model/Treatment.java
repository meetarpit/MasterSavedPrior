package com.test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Treatment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int treatId;
	private String name;
	private String type;
	private String treatedBy;
	
	@ManyToOne
	@JoinColumn(name="pat_id")
	private Patient patient;
	
	
	
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public int getTreatId() {
		return treatId;
	}
	public void setTreatId(int treatId) {
		this.treatId = treatId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTreatedBy() {
		return treatedBy;
	}
	public void setTreatedBy(String treatedBy) {
		this.treatedBy = treatedBy;
	}
	@Override
	public String toString() {
		return "Treatment [treatId=" + treatId + ", name=" + name + ", type=" + type + ", treatedBy=" + treatedBy + "]";
	}
	
	
	
	
	
}
