
import java.sql.*;
import java.util.logging.Logger; // acá iría org.apache.log4j.logger

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();


        Class.forName("org.h2.Driver").newInstance();
        //jdbc:h2:~/test
        Connection con = DriverManager.getConnection("jdbc:h2:" +
                "~/test", "sa", "");
        Statement stmt = con.createStatement();

        try {

            //Código para crear una tabla. Elimina la tabla si esta ya existe y la
            //vuelve a crear
            String createSql = "DROP TABLE IF EXISTS EMPLEADOS;\n" +
                    "CREATE TABLE EMPLEADOS(ID INT PRIMARY KEY, NAME VARCHAR(255), LASTNAME VARCHAR (225), DNI INT, ADDRESS VARCHAR (255));\n" +
                    "INSERT INTO TEST VALUES(1, 'Pepe', 'Castro', 123123123, 'asd123¡ );\n" +
                    "INSERT INTO TEST VALUES(1, 'Juan', 'Luis', 11423123, 'asd123' );\n" +
                    "INSERT INTO TEST VALUES(2, 'Tomas', 'Romero', 4124124, 'casa123');\n";
            stmt.execute(createSql);
        } catch (Exception e){
            logger.info("H");
        }

            //Codigo para consultar todos los registros de la tabla TEST
            String sql = "select * from EMPLEADOS";
            ResultSet rd = stmt.executeQuery(sql);




        //Código para recorrer el resultado de la consulta
        while (rd.next()) {
            System.out.println(rd.getInt(1) + rd.getString(2) + rd.getString(3)) + rd.getString(4) + rd.getString(5);
        }


    }
}
