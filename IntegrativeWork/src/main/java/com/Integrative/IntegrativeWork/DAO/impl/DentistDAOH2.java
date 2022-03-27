package com.Integrative.IntegrativeWork.DAO.impl;
import com.Integrative.IntegrativeWork.DAO.iDao;
import com.Integrative.IntegrativeWork.Domain.Dentist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.*;
import java.util.List;

public class DentistDAOH2 implements iDao<Dentist> {

    Logger logger = LoggerFactory.getLogger(DentistDAOH2.class);


    private static final String DB_JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'create.sql'";
    private static final String DB_USER = "sa";
    private static final String DB_PASS = "";


    @Override
    public Dentist register(Dentist dentist) {
        Connection conn = null;
        PreparedStatement preparedStatement = null;

        String SQL_INSERT = "INSERT INTO dentists(name,surname,register) values(?,?,?)";
        logger.info("Dentist register init");
        try {
            Class.forName(DB_JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            preparedStatement = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, dentist.getName());
            preparedStatement.setString(2, dentist.getSurname());
            preparedStatement.setInt(3, dentist.getRegister());

            preparedStatement.executeUpdate();


            logger.info("Update done");

            ResultSet keys = preparedStatement.getGeneratedKeys();
            if (keys.next()){
                dentist.setId_dentist(keys.getInt(1));
            }
            preparedStatement.close();
            conn.close();



        } catch (Exception e) {
            logger.error("Found an error: " + e.getMessage());
        } return dentist;

    }

    @Override
    public Dentist search(int id) {
        return null;
    }

    @Override
    public Dentist update(int id, Dentist dentist) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Dentist> searchAll() {
        return null;
    }
}
