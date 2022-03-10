package a;

import java.sql.*;
import org.apache.log4j.Logger;

public class Test {

    /*2- Crear un statement para crear una tabla empleado con cinco columnas, la única obligatoria es ID que debe ser ademas PRIMARY KEY, las demas pueden elegirlas.
1- Debemos insertar tres filas con distintos datos, y una de ellas debe tener el ID repetido.
2- Verificar que nuestro log está mostrando este error(Como los id son primary keys al intentar insertar el mismo id, nos va a dar un error, loguear el error).
3- Actualizar a uno de los empleados, con un nuevo valor en alguna de las columnas y loguear con un objeto debug y toda la información del empleado.
4- Eliminar un empleado según el ID y loguear como un objeto info toda la información del empleado eliminado.
5- Eliminar otro empleado según otra columna, ej:email y loguear como un objeto info y loguear como un objeto info toda la información del empleado eliminado.

*/

    private static final String SQL_CREATE_TABLE = "DROP TABLE IF EXISTS EMPLEADO; CREATE TABLE EMPLEADO "
            + "("
            + " ID INT PRIMARY KEY,"
            + " NOMBRE varchar(100) NOT NULL, "
            + " EDAD INT NOT NULL, "
            + " APELLIDO varchar(100) NOT NULL, "
            + " DIRECCION varchar(100) "
            + " )";

    private static final String SQL_INSERT =  "INSERT INTO EMPLEADO (ID, NOMBRE, APELLIDO, EDAD, DIRECCION) VALUES (1, Jorge, Lore, 12, los cardos 456)";
    private static final String SQL_INSERT2 =  "INSERT INTO EMPLEADO (ID, NOMBRE, APELLIDO, EDAD, DIRECCION) VALUES (1, Pino, Lopez, 43, Velez 456)";
    private static final String SQL_INSERT3 =  "INSERT INTO EMPLEADO (ID, NOMBRE, APELLIDO, EDAD, DIRECCION) VALUES (2, Mauri, Paz, 67, Rioja 422)";
    private static final String SQL_UPDATE =  "UPDATE EMPLEADO SET EDAD = 24 WHERE ID = 2";

    private static final String SQL_DELETE =  "DELETE FROM EMPLEADO WHERE ID=2";
    private static final String SQL_DELETE2 =  "DELETE FROM EMPLEADO WHERE NOMBRE=JORGE";

    private static final Logger logger = Logger.getLogger(Test.class);


    public static void main(String[] args) throws Exception {


        Connection connection = null;

        try {
            connection= getConnection();
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE_TABLE);

            Statement statementIns = connection.createStatement();
            statementIns.execute(SQL_INSERT);

            try {
                Statement statementIns2 = connection.createStatement();
                statementIns2.execute(SQL_INSERT2);
            } catch (Exception e) {
                logger.error("error tratando de insertar el empleado: ", e);
            }

            Statement statementIns3 = connection.createStatement();
            statementIns3.execute(SQL_INSERT3);

            Statement statementIns4 = connection.createStatement();
            statementIns4.execute(SQL_UPDATE);
            logger.debug("Estamos actualizando la edad del empleado");



            Statement statementDEl = connection.createStatement();
            statementDEl.execute(SQL_DELETE);

            logger.info("Se elmino el empleado con ID 2");

            Statement statementDEl2 = connection.createStatement();
            statementDEl2.execute(SQL_DELETE2);

            logger.info("Se elmino el empleado con el nombre jorge");


        } catch (Exception e) {

        } finally {
            connection.close();
        }
    }


    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test");

    }

}