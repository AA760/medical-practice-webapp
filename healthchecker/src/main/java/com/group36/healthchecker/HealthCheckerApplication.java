package com.group36.healthchecker;

import java.awt.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.group36.healthchecker.controller.AddressController;
import com.group36.healthchecker.model.Address;
import com.group36.healthchecker.model.Patient;



@SpringBootApplication
@EnableJpaAuditing
public class HealthCheckerApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthCheckerApplication.class, args);
		Patient p=new Patient();
	}

}
