package com.Integrative.IntegrativeWork.DAO.impl;

import com.Integrative.IntegrativeWork.DAO.iDao;
import com.Integrative.IntegrativeWork.Domain.Patient;


import java.util.List;

public class PatientDAOH2 implements iDao<Patient> {



    private static final String DB_JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/integrative;INIT=RUNSCRIPT FROM 'create.sql'";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";



    @Override
    public Patient register(Patient patient) {
        return null;
    }

    @Override
    public Patient search(int id) {
        return null;
    }

    @Override
    public Patient update(int id, Patient patient) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Patient> searchAll() {
        return null;
    }
}
