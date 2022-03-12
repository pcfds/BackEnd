package Asincronica;

import java.sql.*;

public class Test {

    // creo mis tabla completo con INSERT y UPDATE
    private static final String SQL_TABLE_CREATE = "DROP TABLE IF EXISTS USUARIO; CREATE TABLE USUARIO"
            + "("
            + "ID INT PRIMARY KEY,"
            + "NOMBRE VARCHAR (100) NOT NULL,"
            + "EMAIL VARCHAR (100) NOT NULL,"
            + "SUELDO NUMERIC(15, 2) NOT NULL"
            + ")";
    private static final String SQL_INSERT = "INSERT INTO USUARIO (ID, NOMBRE, EMAIL, SUELDO) VALUES (?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE USUARIO SET SUELDO=? WHERE EMAIL=?";

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
            statement.execute(SQL_TABLE_CREATE);

            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);

            // empiezo a insertar en la base de datos que remplazan en orden a los signos de pregunta en SQL_INSERT más arriba
            psInsert.setInt(1, 1);
            psInsert.setString(2, usuario1.getNombre());
            psInsert.setString(3, usuario1.getEmail());
            psInsert.setDouble(4, usuario1.getSueldo());

            psInsert.execute();

            // para actualizar mi base de datos, utiliza lo hecho en SQL_UPDATE para tomar esos indices 1 = sueldo 2= email

            // antes de comenzar la transaccion se debe poner el setAutoCommit

            connection.setAutoCommit(false);

            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);

            psUpdate.setDouble(1, usuario1.subirSueldo(10d));
            psUpdate.setString(2, usuario1.getEmail());
            psUpdate.execute();

            connection.commit();
            connection.setAutoCommit(true);

            // Ahora debemos correr la query

            String sqlQuery = "SELECT * FROM USUARIO;";
            ResultSet rd = statement.executeQuery(sqlQuery);

            while (rd.next()){
                System.out.println(rd.getInt(1) + rd.getString(2) + rd.getString(3));
            }


    } catch (Exception e){

            e.printStackTrace();
            connection.rollback();

       }finally {
            connection.close();

        }

    }

}
