package Trabajo;


import org.h2.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.log4j.Logger;

public class Test {
    private static final Logger logger = Logger.getLogger(Test.class);
    public static void main(String[] args) {
        // BasicConfigurator.configure();



        try {
            // conectando a la base de datos en H2
            Class.forName("org.h2.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            Statement stmt = conexion.createStatement();

            // Vamos a crear la tabla en la base de datos H2
            String createTable = "DROP TABLE IF EXISTS TEST;\n" +
                    "CREATE TABLE TEST(ID INT PRIMARY KEY, NAME VARCHAR(255), EDAD INT);\n";

            stmt.execute(createTable);

            //vamos a  insertar datos

            String insertarDatos = "INSERT INTO TEST VALUES(1,'Juan',23);\n"+
                    "INSERT INTO TEST VALUES(1,'Juan',23)";
            stmt.execute(insertarDatos);
            //consulta a base de datos
            String consulta = "SELECT * FROM TEST;";

            ResultSet rs = stmt.executeQuery(consulta);


            while (rs.next()) {

                System.out.println(rs.getString(3));

            }
            conexion.close();


        } catch (Exception e) {
           logger.error("Este es un error: ", e);
        }
    }
}
