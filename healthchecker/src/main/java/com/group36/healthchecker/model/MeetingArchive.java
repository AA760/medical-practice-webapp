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
@Table(name = "meetings_archive")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)

public class MeetingArchive implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long meeting_archive_Id;
	
	@NotNull
	private Long doctor_Id;

	private Long patient_Id;

	private String reason;

	@Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date date_Time;
//	private Date date_Time;

	@NotNull
	private Long request_Id;

	public MeetingArchive() {

	}

//	public MeetingArchive(@NotNull Long doctor_Id, Long patient_Id, String reason, Date date_Time,
//			@NotNull Long request_Id) {
//		super();
//		this.doctor_Id = doctor_Id;
//		this.patient_Id = patient_Id;
//		this.reason = reason;
//		this.date_Time = date_Time;
//		this.request_Id = request_Id;
//	}

	public MeetingArchive(@NotNull Long doctor_Id, Long patient_Id, String reason, Date date_Time,
			@NotNull Long request_Id) {
		super();
		this.doctor_Id = doctor_Id;
		this.patient_Id = patient_Id;
		this.reason = reason;
		this.date_Time = date_Time;
		this.request_Id = request_Id;
	}
	
	
	public Long getMeeting_archive_Id() {
		return meeting_archive_Id;
	}

	public void setMeeting_archive_Id(Long meeting_archive_Id) {
		this.meeting_archive_Id = meeting_archive_Id;
	}

	public Long getDoctor_Id() {
		return doctor_Id;
	}

	public void setDoctor_Id(Long doctor_Id) {
		this.doctor_Id = doctor_Id;
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

	public Long getRequest_Id() {
		return request_Id;
	}

	public void setRequest_Id(Long request_Id) {
		this.request_Id = request_Id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
