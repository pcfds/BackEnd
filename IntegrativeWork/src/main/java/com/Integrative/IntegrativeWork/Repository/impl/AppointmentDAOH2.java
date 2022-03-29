package com.Integrative.IntegrativeWork.Repository.impl;

import com.Integrative.IntegrativeWork.Repository.iDao;
import com.Integrative.IntegrativeWork.Domain.Appointment;
import com.Integrative.IntegrativeWork.Domain.Dentist;
import com.Integrative.IntegrativeWork.Domain.Patient;
import com.Integrative.IntegrativeWork.Services.DentistService;
import com.Integrative.IntegrativeWork.Services.PatientService;
import org.slf4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAOH2 implements iDao<Appointment> {



    Logger logger = org.slf4j.LoggerFactory.getLogger(AppointmentDAOH2.class);


    private static final String DB_JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URl = "jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'create.sql'";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";
    PatientService patientService = new PatientService(new PatientDAOH2());
    DentistService dentistService = new DentistService(new DentistDAOH2());



    @Override
    public Appointment register(Appointment appointment) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String SQL_INSERT = "INSERT INTO appointments (dentist_id, patient_id, date_init) VALUES ( ?, ?, ?)";
        try {
            logger.info("Registering new appointment");
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            preparedStatement = connection.prepareStatement(SQL_INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, appointment.getDentist().getId_dentist());
            preparedStatement.setInt(2, appointment.getPatient().getId_patient());
            preparedStatement.setDate(3, new Date(appointment.getDate().getTime()));
            preparedStatement.executeUpdate();
            ResultSet keys = preparedStatement.getGeneratedKeys();
            if (keys.next()) {
                appointment.setId_appointment(keys.getInt(1));
            }
            logger.info("Appointment registered successfully");

        } catch (Exception e) {
            logger.error("Error registering appointment" + e.getMessage());
        }
        return appointment;
    }

    @Override
    public Appointment search(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String SQL_SELECT = "SELECT * FROM APPOINTMENTS WHERE ID = ?";
        Appointment appointment = null;

        try {
            logger.info("Searching for appointment");
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Patient patient = patientService.search(resultSet.getInt(2));
                Dentist dentist = dentistService.search(resultSet.getInt(3));
                appointment = new Appointment(resultSet.getInt(1), dentist, patient, new java.util.Date(resultSet.getDate(4).getTime()));
            }
            logger.info("Appointment found successfully");
            preparedStatement.close();
            connection.close();

        } catch (Exception e) {
            logger.error("Error searching for appointment" + e.getMessage());
        }
        return appointment;

    }

    @Override
    public Appointment update(int id, Appointment appointment) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String SQL_UPDATE = "UPDATE APPOINTMENTS SET PATIENT_ID = ?, DENTIST_ID = ?, DATE = ? WHERE ID = ?";
        Appointment appointment1 = null;
        try {
            logger.info("Updating appointment");
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setInt(2, appointment.getDentist().getId_dentist());
            preparedStatement.setInt(3, appointment.getPatient().getId_patient());
            preparedStatement.setDate(4, new Date(appointment.getDate().getTime()));
            preparedStatement.setInt(5, id);
            preparedStatement.executeUpdate();

            appointment1 = appointment;
            appointment1.setId_appointment(id);
            logger.info("Appointment updated successfully");

        } catch (Exception e) {
            logger.error("Error updating appointment, " + e.getMessage());
        }
        return appointment1;
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String SQL_DELETE = "DELETE FROM APPOINTMENTS WHERE ID = ?";
        try {
            logger.info("Deleting appointment");
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            preparedStatement = connection.prepareStatement(SQL_DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            logger.info("Appointment deleted successfully");

        } catch (Exception e) {
            logger.error("Error deleting appointment, " + e.getMessage());
        }
    }

    @Override
    public List<Appointment> searchAll() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String SQL_SELECT = "SELECT * FROM APPOINTMENTS";
        List<Appointment> appointmentsList = new ArrayList();
        try {
            logger.info("Searching for all appointments");
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URl, DB_USER, DB_PASS);
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Patient patient = patientService.search(resultSet.getInt(3));
                Dentist dentist = dentistService.search(resultSet.getInt(2));
                Appointment appointment = new Appointment(resultSet.getInt(1), dentist, patient, new java.util.Date(resultSet.getDate(4).getTime()));
                appointmentsList.add(appointment);
            }
            logger.info("All appointments found successfully");
        } catch (Exception e) {
            logger.error("Error searching for all appointments, " + e.getMessage());
        }
        return appointmentsList;
    }
}
