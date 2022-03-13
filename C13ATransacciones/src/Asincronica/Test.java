package Asincronica;

import java.sql.*;

public class Test {

    // creo mis tabla completo con INSERT y UPDATE
    private static final String sql_create_table = "DROP TABLE IF EXISTS USUARIO; CREATE TABLE USUARIO"
            + "("
            + "ID INT PRIMARY KEY,"
            + "NOMBRE VARCHAR (100) NOT NULL,"
            + "EMAIL VARCHAR (100) NOT NULL,"
            + "SUELDO NUMERIC(15, 2) NOT NULL"
            + ")";
    private static final String sql_insert = "INSERT INTO USUARIO (id, nombre, email, sueldo) VALUES (?,?,?,?)";
    private static final String sql_update = "UPDATE USUARIO SET sueldo=? WHERE email=?";

    // creo la conexión a mi base de datos

    private static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:" + "./Database/my", "root", "");

    }


    public static void main(String[] args) throws Exception {
        Usuario usuario1 = new Usuario("Pedro", "a@a.com", 200d);

        Connection connection = null;

        try{
            connection = getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sql_create_table);

            PreparedStatement psInsert = connection.prepareStatement(sql_insert);

            // empiezo a insertar en la base de datos que remplazan en orden a los signos de pregunta en SQL_INSERT más arriba
            psInsert.setInt(1, 1);
            psInsert.setString(2, usuario1.getNombre());
            psInsert.setString(3, usuario1.getEmail());
            psInsert.setDouble(4, usuario1.getSueldo());

            psInsert.execute();

            // para actualizar mi base de datos, utiliza lo hecho en SQL_UPDATE para tomar esos indices 1 = sueldo 2= email

            // antes de comenzar la transaccion se debe poner el setAutoCommit

            connection.setAutoCommit(false);

            PreparedStatement psUpdate = connection.prepareStatement(sql_update);

            psUpdate.setDouble(1, usuario1.subirSueldo(10d));
            psUpdate.setString(2, usuario1.getEmail());
            psUpdate.execute();
            int a = 4 / 0;

            connection.commit();
            connection.setAutoCommit(true);

            // Ahora debemos correr la query

            String sqlQuery = "SELECT * FROM USUARIO;";
            ResultSet rd = statement.executeQuery(sqlQuery);

            while (rd.next()){
                System.out.println(rd.getInt(1) + rd.getString(2) + rd.getString(3) + rd.getDouble(4));
            }


    } catch (Exception e){

            e.printStackTrace();
            connection.rollback();

       }finally {
            connection.close();

        }

        Connection connection1 = getConnection();
        String sqlQuery = "SELECT * FROM USUARIO;";
        Statement statement = connection1.createStatement();
        ResultSet rd = statement.executeQuery(sqlQuery);

        while (rd.next()){
            System.out.println(rd.getInt(1) + rd.getString(2) + rd.getString(3) + rd.getDouble(4));
        }





    }

}
