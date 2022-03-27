package com.Integrative.IntegrativeWork.DAO.impl;

import com.Integrative.IntegrativeWork.DAO.iDao;
import com.Integrative.IntegrativeWork.Domain.Appointment;

import java.util.List;

public class AppointmentDAOH2 implements iDao<Appointment> {


    private static final String DB_JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/integrative;INIT=RUNSCRIPT FROM 'create.sql'";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";


    @Override
    public Appointment register(Appointment appointment) {
        return null;
    }

    @Override
    public Appointment search(int id) {
        return null;
    }

    @Override
    public Appointment update(int id, Appointment appointment) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Appointment> searchAll() {
        return null;
    }
}
