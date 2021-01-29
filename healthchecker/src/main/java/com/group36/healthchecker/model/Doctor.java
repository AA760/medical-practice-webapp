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
@Table(name = "doctor")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)

public class Doctor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long doctor_Id;

	@NotBlank
	private String first_Name;

	@NotBlank
	private String last_Name;

	@NotNull
	private Date dob;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date dor;

	@NotNull
	private Long address_Id;

	@NotBlank
	private String phone_No;

	@NotNull
	private Long user_Id;

	public Doctor() {

	}

	public Doctor(@NotBlank String first_Name, @NotBlank String last_Name, @NotNull Date dob, @NotNull Long address_Id,
			@NotBlank String phone_No, @NotNull Long user_Id) {
		super();
		this.first_Name = first_Name;
		this.last_Name = last_Name;
		this.dob = dob;
		this.address_Id = address_Id;
		this.phone_No = phone_No;
		this.user_Id = user_Id;
	}

	public Long getDoctor_Id() {
		return doctor_Id;
	}

	public void setDoctor_Id(Long doctor_Id) {
		this.doctor_Id = doctor_Id;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
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

	public Long getAddress_Id() {
		return address_Id;
	}

	public void setAddress_Id(Long address_Id) {
		this.address_Id = address_Id;
	}

	public String getPhone_No() {
		return phone_No;
	}

	public void setPhone_No(String phone_No) {
		this.phone_No = phone_No;
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
