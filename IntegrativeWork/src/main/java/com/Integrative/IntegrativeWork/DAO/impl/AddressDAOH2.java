package com.Integrative.IntegrativeWork.DAO.impl;

import com.Integrative.IntegrativeWork.DAO.iDao;
import com.Integrative.IntegrativeWork.Domain.Address;


import java.util.List;

public class AddressDAOH2 implements iDao<Address> {


    private static final String DB_JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/integrative;INIT=RUNSCRIPT FROM 'create.sql'";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";

    @Override
    public Address register(Address address) {
        return null;
    }

    @Override
    public Address search(int id) {
        return null;
    }

    @Override
    public Address update(int id, Address address) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Address> searchAll() {
        return null;
    }
}
