package com.Integrative.IntegrativeWork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class IntegrativeWorkApplication {

	private static void uploadDB(){
		Connection connection=null;
		try{
			//conectarnos para crear la BD
			Class.forName("org.h2.Driver");
			connection= DriverManager.getConnection("jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'create.sql'","sa","");
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally {
			try{
				connection.close();
			}
			catch (SQLException ex){
				ex.printStackTrace();
			}
		}
	}


	public static void main(String[] args) {
		uploadDB();
		SpringApplication.run(IntegrativeWorkApplication.class, args);
	}

}
