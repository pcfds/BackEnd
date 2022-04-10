package ApiRestFinalProject.DentalClinic;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DentalClinicApplication {

	@Bean // Es una componente de JAVA que nos permite mapear objetos de una clase a otra
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	public static void main(String[] args) {




		SpringApplication.run(DentalClinicApplication.class, args);

	}

}
