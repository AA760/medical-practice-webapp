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
@Table(name = "treatment")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "Created at", "Updated at" }, allowGetters = true)
public class treatment implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long treatment_Id;
	@NotNull
	private String name;
	@NotNull
	private String description;
	@NotNull
	private Integer effective_On_Disease_Id;
	
	public treatment(Long treatment_Id, String name, String description, Integer effective_On_Disease_Id) {
		this.treatment_Id = treatment_Id;
		this.name = name;
		this.description = description;
		this.effective_On_Disease_Id = effective_On_Disease_Id;
		
	}
	
	public Long gettreatment_Id() {
		return treatment_Id;
	}
	public void settreatment_Id(Long treatment_Id) {
		this.treatment_Id = treatment_Id;
	}
	
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	
	public String getdescription() {
		return description;
	}
	public void setdescription(String description) {
		this.description = description;
	}
	
	public Integer geteffective_On_Disease_Id() {
		return effective_On_Disease_Id;
	}
	public void seteffective_On_Disease_Id(Integer effective_On_Disease_Id) {
		this.effective_On_Disease_Id = effective_On_Disease_Id;
	}

}
