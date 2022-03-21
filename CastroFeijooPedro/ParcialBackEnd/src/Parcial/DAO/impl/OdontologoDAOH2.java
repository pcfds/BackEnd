package Parcial.DAO.impl;

import Parcial.DAO.iDao;
import Parcial.Models.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class OdontologoDAOH2 implements iDao<Odontologo> {
    private static final Logger logger = Logger.getLogger(OdontologoDAOH2.class);

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/test;INIT=RUNSCRIPT FROM 'create.sql'";
    // Después de varios intentos, sacando el INIT y creando manual en H2 lo conseguí. Saludos Peter.
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";

    public OdontologoDAOH2() {

    }


    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            preparedStatement = connection.prepareStatement("INSERT INTO odontologo(numero_matricula,nombre, apellido) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, odontologo.getNumeroDeMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());


            preparedStatement.executeUpdate();
            logger.info("Se ejecuto correctamente");
            ResultSet keys = preparedStatement.getGeneratedKeys();
            if (keys.next())
                odontologo.setId(keys.getInt(1));

            preparedStatement.close();

        } catch (Exception e) {
            logger.error("Se encontró el siguiente error: " + e.getMessage());
        }
        return odontologo;
    }

    @Override
    public Odontologo buscar(int id) {
        Odontologo odontologo = null;
        Connection conn = null;
        PreparedStatement prepareStatement = null;
        String SQL_SELECT = "SELECT * FROM odontologo WHERE ID=?";

        try {
            logger.info("Buscar Odontologo inicializado");
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            prepareStatement = conn.prepareStatement(SQL_SELECT);
            prepareStatement.setInt(1, id);
            ResultSet rs = prepareStatement.executeQuery();

            while (rs.next()) {

                odontologo = new Odontologo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
            }
            prepareStatement.close();
            logger.info("Se trajo al odontologo");

        } catch (Exception e) {
            logger.error("El siguiente error se encontró: " + e.getMessage());

        }
        return odontologo;
    }

    @Override
    public void eliminar(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {

            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);


            preparedStatement = connection.prepareStatement("DELETE FROM odontologo where id = ?");
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            preparedStatement.close();
            logger.info("Se ha eliminado con exito");
        } catch (Exception e) {
            logger.error("Se ha encontrado el siguiente error: " + e.getMessage());
        }


    }

    @Override
    public List<Odontologo> buscarTodos() {
        List<Odontologo> odontologos = new ArrayList<>();
        Connection conn = null;
        PreparedStatement prepareStatement = null;
        String SQL_SELECT_ALL = " SELECT * FROM odontologo";
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            prepareStatement = conn.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                Odontologo odontologo = new Odontologo(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4));
                odontologos.add(odontologo);
            }
            prepareStatement.close();
            logger.info("Buscar todo los odontologos: SUCCESS");

        } catch (Exception e) {
            logger.error("Buscar todo los odontologos: ERROR, " + e.getMessage());
        }
        return odontologos;
    }
}
