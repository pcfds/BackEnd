package com.Integrative.IntegrativeWork;
import com.Integrative.IntegrativeWork.Repository.impl.DentistDAOH2;
import com.Integrative.IntegrativeWork.Domain.Dentist;
import com.Integrative.IntegrativeWork.Services.DentistService;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootTest
class IntegrativeWorkApplicationTests {



//	public static boolean datosTesteo() {
//		Dentist dentist = new Dentist("Pablo", "Perez", 32424);
//		boolean conn = false;
//		String DB_JDBC_DRIVER = "org.h2.Driver";
//		String DB_URl = "jdbc:h2:~/test";
//		String DB_USER = "sa";
//		String DB_PASS = "";
//
//		try {
//			Class.forName(DB_JDBC_DRIVER);
//			Connection connection = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
//			if (connection != null) {
//				conn = true;
//			}
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//		return conn;
//	}
//		@Test
//		public void createDentists() {
//			DentistService dentistService = new DentistService(new DentistDAOH2());
//			Dentist dentist = new Dentist("Pablo", "Perez", 32424);
//			Assertions.assertTrue(dentistService.register(dentist).getId() >= 0 && datosTesteo());
//		}
//
//		@Test
//		public void searchDentist() {
//			DentistService dentistService = new DentistService(new DentistDAOH2());
//			Dentist dentist = dentistService.search(1);
//				Assertions.assertEquals("Pablo", dentist.getName());
//		}
//		@Test
//		public void updateDentist() {
//			DentistService dentistService = new DentistService(new DentistDAOH2());
//			Dentist dentist = new Dentist("Juani", "Martinez", 629);
//			dentistService.update(1, dentist);
//			Assertions.assertEquals("Juani", dentist.getName());
//		}
//
//		@Test
//		public void deleteDentist() {
//			DentistService dentistService = new DentistService(new DentistDAOH2());
//			dentistService.delete(1);
//			Assertions.assertTrue(dentistService.search(1) == null && datosTesteo());
//		}


	}




