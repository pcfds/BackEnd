package DAO.impl;

import DAO.iDao;
import model.Paciente;
import org.apache.log4j.Logger;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;


public class PacienteDAOH2 implements iDao<Paciente> {
    private static final Logger logger = Logger.getLogger(PacienteDAOH2.class);

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/test";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";

    public PacienteDAOH2() {
    }

    @Override
    public Paciente guardar(Paciente paciente) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //1 Levantar el driver y Conectarnos
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            System.out.println(logger.info("La conexión fue exitosa");

            //2 Crear una sentencia
            preparedStatement = connection.prepareStatement("INSERT INTO paciente VALUES(?,?,?,?,?)");
            preparedStatement.setLong(1,paciente.getId());
            preparedStatement.setString(2, paciente.getNombre());
            preparedStatement.setString(3, paciente.getApellido());
            preparedStatement.setInt(4, paciente.getDni());
            preparedStatement.setDate(5, Util.utilDateToSqlDate(paciente.getFechaDeIngreso()));
            preparedStatement.setString(6, paciente.getDomicilio());


            //3 Ejecutar una sentencia SQL
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (Exception e) {
            logger.error("Este fue el error; " + e.getMessage());
        }
        return paciente;    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public Paciente buscar(Long id) {
        return null;
    }

    @Override
    public Paciente modificar(Long id) {
        return null;
    }

    @Override
    public List<Paciente> buscarTodos() {
        return null;
    }
}
