package com.example.groupproject.model;

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
@Table(name = "Address")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)

public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long address_Id;

		@NotBlank
		private String line1;

		
		private String line2;
		
		@NotBlank
		private String postcode;
		
		@NotBlank
		private String city;
		
		@NotBlank
		private String country;

	
	public Address() {

	}

	public Address( String line1, String line2,  String postcode,
			 String city,  String country) {
		super();
		this.line1 = line1;
		this.line2 = line2;
		this.postcode = postcode;
		this.city = city;
		this.country = country;
	}

	public Long getAddressid() {
		return address_Id;
	}

	public void setAddressid(Long address_Id) {
		this.address_Id = address_Id;
	}
	
	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
