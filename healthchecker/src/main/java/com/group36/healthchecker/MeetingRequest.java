package com.group36.healthchecker.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "meeting_request")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)

public class MeetingRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long request_Id;

	@NotNull
	private Long patient_Id;

	@NotNull
	private String reason;

//	@NotNull
//	private Date date_Time;
	
	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date date_Time;

//	@NotBlank
	private byte accepted;

//	@NotBlank
	private Long doctor_Id;

	@NotNull
	private Long address_id;

//	@NotBlank
	private String first_name;

//	@NotBlank
	private String last_name;

//	@NotBlank
	private String phone;

	@NotNull
	private Long user_id;

	public MeetingRequest() {

	}

	public MeetingRequest(@NotBlank Long patient_Id, @NotBlank String reason, byte accepted,
			@NotBlank Long doctor_Id, @NotBlank Long address_id, @NotBlank String first_name,
			@NotBlank String last_name, @NotBlank String phone, @NotBlank Long user_id) {
		super();
		this.patient_Id = patient_Id;
		this.reason = reason;
//		this.date_Time = date_Time;
		this.accepted = accepted;
		this.doctor_Id = doctor_Id;
		this.address_id = address_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone = phone;
		this.user_id = user_id;
	}

	public Long getRequest_Id() {
		return request_Id;
	}

	public void setRequest_Id(Long request_Id) {
		this.request_Id = request_Id;
	}

	public Long getPatient_Id() {
		return patient_Id;
	}

	public void setPatient_Id(Long patient_Id) {
		this.patient_Id = patient_Id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Date getDate_Time() {
		return date_Time;
	}

	public void setDate_Time(Date date_Time) {
		this.date_Time = date_Time;
	}

	public byte getAccepted() {
		return accepted;
	}

	public void setAccepted(byte accepted) {
		this.accepted = accepted;
	}

	public Long getDoctor_Id() {
		return doctor_Id;
	}

	public void setDoctor_Id(Long doctor_Id) {
		this.doctor_Id = doctor_Id;
	}

	public Long getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Long address_id) {
		this.address_id = address_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
