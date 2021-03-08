package com.group36.healthchecker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "patient")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)

public class Patient implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long patient_Id;

	@NotBlank
	private String firstName;

	@NotBlank
	private String lastName;

	@NotNull
	private Date dob;

//		@NotBlank
//		private String dor;

//	@Column(nullable = false)
//	@Temporal(TemporalType.TIMESTAMP)
//	@LastModifiedDate
//	private Date dor;
	
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date dor;


	@NotNull
	private Long addressId;

	@NotBlank
	private String phone;



	@NotNull
	private Long user_Id;



	public Patient() {

	}

	public Patient(String firstName, String lastName, Date dob, Long addressId, String phone,Long userId) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.addressId = addressId;
		this.phone = phone;
		this.user_Id = userId;
	}

	
	public Long getPatient_Id() {
		return patient_Id;
	}

	public void setPatient_Id(Long patient_Id) {
		this.patient_Id = patient_Id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getDor() {
		return dor;
	}

	public void setDor(Date dor) {
		this.dor = dor;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}



	public Long getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(Long user_Id) {
		this.user_Id = user_Id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
