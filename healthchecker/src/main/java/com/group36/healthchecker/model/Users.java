package com.group36.healthchecker.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;


import java.io.Serializable;


@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)

public class Users implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String userName;

	@NotBlank
	private String password;

	@NotBlank
	private String roles;

	@NotBlank
	private String active;

	public Users() {

	}

	public Users(@NotBlank String user_name, @NotBlank String password, @NotBlank String roles,
			@NotBlank String active) {
		super();
		this.userName = user_name;
		this.password = password;
		this.roles = roles;
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser_name() {
		return userName;
	}

	public void setUser_name(String user_name) {
		this.userName = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}