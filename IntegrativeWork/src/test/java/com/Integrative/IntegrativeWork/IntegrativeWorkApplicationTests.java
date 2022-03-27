package com.Integrative.IntegrativeWork;

import com.Integrative.IntegrativeWork.DAO.impl.DentistDAOH2;
import com.Integrative.IntegrativeWork.Domain.Dentist;
import com.Integrative.IntegrativeWork.Services.DentistService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IntegrativeWorkApplicationTests {


	@Test
	public void registerDentist(){

		DentistService dentistService = new DentistService(new DentistDAOH2());
		Dentist dentist = new Dentist("Pedro", "Castro", 2323);
		dentistService.register(dentist);
		Assertions.assertNotNull(dentistService.register(dentist));

	}

}
