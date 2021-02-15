package com.group36.healthchecker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.group36.healthchecker.repository.*;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class HealthcheckerApplication 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(HealthcheckerApplication.class, args);
		
	}

}