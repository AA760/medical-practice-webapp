package com.group36.healthchecker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "patient_medical_history")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)

public class MedicalHistory implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long medical_History_Id;


	private String receiving_Treatment;


	private String current_Medication;


	private String allergies;


	private int covid19_Victim;


	private String transplants;


	private int pacemaker;


	private int smoker;

	public MedicalHistory() {

	}

	public MedicalHistory(String receiving_Treatment, String current_Medication, String allergies, int covid19_Victim,
			String transplants, int pacemaker, int smoker) {
		super();
		this.receiving_Treatment = receiving_Treatment;
		this.current_Medication = current_Medication;
		this.allergies = allergies;
		this.covid19_Victim = covid19_Victim;
		this.transplants = transplants;
		this.pacemaker = pacemaker;
		this.smoker = smoker;
	}

	public Long getMedical_History_Id() {
		return medical_History_Id;
	}

	public void setMedical_History_Id(Long medical_History_Id) {
		this.medical_History_Id = medical_History_Id;
	}

	public String getReceiving_Treatment() {
		return receiving_Treatment;
	}

	public void setReceiving_Treatment(String receiving_Treatment) {
		this.receiving_Treatment = receiving_Treatment;
	}

	public String getCurrent_Medication() {
		return current_Medication;
	}

	public void setCurrent_Medication(String current_Medication) {
		this.current_Medication = current_Medication;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public int getCovid19_Victim() {
		return covid19_Victim;
	}

	public void setCovid19_Victim(int covid19_Victim) {
		this.covid19_Victim = covid19_Victim;
	}

	public String getTransplants() {
		return transplants;
	}

	public void setTransplants(String transplants) {
		this.transplants = transplants;
	}

	public int getPacemaker() {
		return pacemaker;
	}

	public void setPacemaker(int pacemaker) {
		this.pacemaker = pacemaker;
	}

	public int getSmoker() {
		return smoker;
	}

	public void setSmoker(int smoker) {
		this.smoker = smoker;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
