package com.group36.healthchecker.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "patient_Record")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)

public class Patient_Record implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long record_Id;

	@NotNull
	private Long patient_Id;

	@NotNull
	private Long medical_History_Id;

	
	public Patient_Record() {

	}

	public Patient_Record(Long patient_Id, Long medical_History_Id) {
		this.patient_Id = patient_Id;
		this.medical_History_Id = medical_History_Id;
	}

	public Long getRecord_Id() {
		return record_Id;
	}

	public void setRecord_Id(Long record_Id) {
		this.record_Id = record_Id;
	}

	public Long getPatient_Id() {
		return patient_Id;
	}

	public void setPatient_Id(Long patient_Id) {
		this.patient_Id = patient_Id;
	}

	public Long getMedical_History_Id() {
		return medical_History_Id;
	}

	public void setMedical_History_Id(Long medical_History_Id) {
		this.medical_History_Id = medical_History_Id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
