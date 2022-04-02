package com.Integrative.IntegrativeWork;

import com.Integrative.IntegrativeWork.Domain.Dentist;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntegrativeWorkApplication {

	Dentist dentist = new Dentist("Pedro", "Castro", 1234);


	public static void main(String[] args) {
		SpringApplication.run(IntegrativeWorkApplication.class, args);
	}

}
