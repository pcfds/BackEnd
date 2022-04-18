package Trabajo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.log4j.Logger;

public class BD {

    private Connection conexion;
    private Statement declaracion;
    private Logger logger;

    public BD(String conexion) {

        try {
            this.logger = Logger.getLogger(BD.class);
        }catch (Exception e){
            System.out.println(e.getMessage());

        }

        // inicializando conexion

        try {

            this.conexion = DriverManager.getConnection(conexion);
          logger.info("Se establecio la conexion");
        }catch (Exception e){
            logger.error("No se pudo establecer la conexion" + e);

        }

        // iniciar declaraciones

        try {

            this.declaracion = this.conexion.createStatement();
            logger.info("Se ha iniciado el objeto de declaraciones");

        }catch (Exception e){
            logger.error("No se pudo inicializar " + e);

        }

    }

    public void insertarDatos(String sql) {
    }


    public void creacionDeTabla(String sql) {
    }


    public void actualizarDatos(String sql) {
    }

    public void eliminarDatos(String sql) {
    }

    public ResultSet consultaDeDatos(String sql) {
        return null;

    }
    public void cerrarConexion(){

    }


}
