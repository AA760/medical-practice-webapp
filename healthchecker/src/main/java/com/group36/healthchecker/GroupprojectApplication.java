package com.example.groupproject;

import java.awt.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.groupproject.controller.AddressController;
import com.example.groupproject.model.Address;
import com.example.groupproject.model.Patient;



@SpringBootApplication
@EnableJpaAuditing
public class GroupprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroupprojectApplication.class, args);
		Patient p=new Patient();
//		System.out.println(p.getId());
//		p.setFirstName("Hello");
//		System.out.println(p.getId());
//		System.out.println(p.getFirstName());
//		AddressController addressController = new AddressController();
//		List address=(List) addressController.getAllAddress();
//		System.out.println(address);
	}

}
