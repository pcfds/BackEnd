package practica;

import org.apache.log4j.Logger;

import java.sql.*;


public class Test {

    private static final Logger logger = Logger.getLogger(Test.class);

    // creando las tablas


    private static final String sql_create_table = "DROP TABLE IF EXISTS USUARIO;" + "CREATE TABLE USUARIO"
            + "("
            + "ID INT PRIMARY KEY,"
            + "nombre VARCHAR (100) NOT NULL,"
            + "apellido VARCHAR (100) NOT NULL,"
            + "domicilio VARCHAR (100) NOT NULL,"
            + "dni INT NOT NULL,"
            + "fechaAlta INT NOT NULL,"
            + "usuario VARCHAR (100) NOT NULL,"
            + "contrasenia VARCHAR (100) NOT NULL,"
            + ")";

    // creando insert
    private static final String sql_insert = "INSERT INTO USUARIO VALUES (?,?,?,?,?,?,?,?);";

    // actualizando datos
    private static final String sql_update = "UPDATE USUARIO SET contrasenia=? WHERE dni=?;";

    // creando conexion

    private static Connection getConnection() throws Exception{

        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:" +
                "~/test", "sa", "");

    }

    public static void main(String[] args) throws Exception {


        Pacientes paciente1 = new Pacientes("Pedro", "Castro Feijoo", "DH 123", 123455, 25 - 5, "pedrocf", "1234");

        Connection connection = getConnection();
        try {


            // ejecutamos el creado de la tabla

            Statement statement = connection.createStatement();
            statement.execute(sql_create_table);

            // insertando datos

            PreparedStatement psInsert = connection.prepareStatement(sql_insert);

            psInsert.setInt(1, 1);
            psInsert.setString(2, paciente1.getNombre());
            psInsert.setString(3, paciente1.getApellido());
            psInsert.setString(4, paciente1.getDomicilio());
            psInsert.setInt(5, paciente1.getDni());
            psInsert.setInt(6, paciente1.getFechDeAlta());
            psInsert.setString(7, paciente1.getUsuario());
            psInsert.setString(8, paciente1.getContrasenia());

            psInsert.execute();

            // empezar la transacción
            connection.setAutoCommit(false);

            // actualizamos datos

            PreparedStatement psUpdate = connection.prepareStatement(sql_update);
            psUpdate.setString(1, paciente1.cambiarContrasenia("casa"));
            psUpdate.setInt(2, paciente1.getDni());
            psUpdate.execute();

            connection.commit();

            connection.setAutoCommit(true);

            // correr la query

            String sql = "SELECT * FROM USUARIO;";
            ResultSet rd = statement.executeQuery(sql);

            while (rd.next()) {
                System.out.println(rd.getInt(1) + rd.getString(2) + rd.getString(3) + rd.getString(4) + rd.getInt(5) + rd.getInt(6) + rd.getString(7) + rd.getString(8));
            }


        } catch (Exception e) {

            logger.error("Este es el siguiente error: " + e.getMessage());

            connection.rollback();


        } finally {

            connection.close();

        }

        System.out.println(paciente1.toString());


    }
}

