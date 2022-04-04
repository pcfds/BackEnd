package com.Integrative.IntegrativeWork.Repository.impl;
import com.Integrative.IntegrativeWork.Repository.iDao;
import com.Integrative.IntegrativeWork.Domain.Dentist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository

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
        AddressDAOH2 addressDAOH2 = new AddressDAOH2();

        String SQL_INSERT = "INSERT INTO dentists(name,surname,register) values(?,?,?)";
//        logger.info("Dentist register init");
        try {
            //1 Levantar el driver y Conectarnos
            Class.forName(DB_JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            //2 Crear una sentencia especificando que el ID lo auto incrementa la base de datos y que nos devuelva esa Key es decir ID


            preparedStatement = conn.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);

            //No le vamos a pasar el ID ya que hicimos que fuera autoincremental en la base de datos
            //preparedStatement.setInt(1,domicilio.getId());

            preparedStatement.setString(1, dentist.getName());
            preparedStatement.setString(2, dentist.getSurname());
            preparedStatement.setInt(3, dentist.getRegister());

//3 Ejecutar una sentencia SQL y obtener los ID que se autogeneraron en la base de datos

            preparedStatement.executeUpdate();
            logger.info("Update done");
            ResultSet keys = preparedStatement.getGeneratedKeys();
            if (keys.next()){
                dentist.setId(keys.getInt(1));
            }
            preparedStatement.close();
            conn.close();




        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } return dentist;

    }

    @Override
    public Dentist search(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Dentist dentist = null;
        try {
            //1 Levantar el driver y Conectarnos
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            //2 Crear una sentencia
            preparedStatement = connection.prepareStatement("SELECT id, name, surname, register FROM dentists where id = ?");
            preparedStatement.setInt(1,id);

            //3 Ejecutar una sentencia SQL
            ResultSet result = preparedStatement.executeQuery();

            //4 Obtener resultados
            while (result.next()) {
                int id_dentist = result.getInt(1);
                String name = result.getString(2);
                String surname = result.getString(3);
                int register = result.getInt(4);


               dentist = new Dentist(id_dentist,name, surname, register);
            }

            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return dentist;
    }

    @Override
    public Dentist searchEmail(String email) {
        return null;
    }

    @Override
    public Dentist update(Integer id, Dentist dentist) {


        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //1 Levantar el driver y Conectarnos
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            preparedStatement = connection.prepareStatement("UPDATE dentists SET name = ?, surname = ?, register = ? WHERE id = ?");
            //No le vamos a pasar el ID ya que hicimos que fuera autoincremental en la base de datos
            //preparedStatement.setInt(1,domicilio.getId());
            preparedStatement.setString(1, dentist.getName());
            preparedStatement.setString(2, dentist.getSurname());
            preparedStatement.setInt(3, dentist.getRegister());
            preparedStatement.setInt(4, dentist.getId());

            //3 Ejecutar una sentencia SQL y obtener los ID que se autogeneraron en la base de datos
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return dentist;
    }


    @Override
    public void delete(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //1 Levantar el driver y Conectarnos
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            //2 Crear una sentencia
            preparedStatement = connection.prepareStatement("DELETE FROM dentists where id = ?");
            preparedStatement.setInt(1,id);

            //3 Ejecutar una sentencia SQL
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public List<Dentist> searchAll() {


        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Dentist> dentists = new ArrayList<>();
        try {
            //1 Levantar el driver y Conectarnos
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);

            //2 Crear una sentencia
            preparedStatement = connection.prepareStatement("SELECT *  FROM dentists");

            //3 Ejecutar una sentencia SQL
            ResultSet result = preparedStatement.executeQuery();

            //4 Obtener resultados
            while (result.next()) {

                int id = result.getInt(1);
                String name = result.getString(2);
                String surname = result.getString(3);
                int register = result.getInt(4);


                Dentist dentist = new Dentist(id,name,surname,register);

                dentists.add(dentist);

            }

            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        return dentists;
    }
}
