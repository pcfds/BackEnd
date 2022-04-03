package ejercicePacientes.dao;

import ejercicePacientes.entities.Domicilio;
import ejercicePacientes.entities.Paciente;
import ejercicePacientes.services.PacienteService;
import ejercicePacientes.util.Util;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class   ImplPacienteDaoH2 implements IDao<Paciente>{

    private final static String DB_JDBC_DRIVER = "org.h2.Driver"; //guardamos driver de h2
    private final static String DB_URL = "jdbc:h2:~/db_clinica;"; //BASE DE DATOS URL
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";

    Connection connection = null;
    PreparedStatement preparedStatement = null;

    public void getConnection() throws Exception{
        Class.forName(DB_JDBC_DRIVER);
        connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    //Invoco domicilio para crearlo y utilizar su id en paciente
    private ImpDomicilioDaoH2 impDomicilioDaoH2 = new ImpDomicilioDaoH2();

    private static final Logger logger = Logger.getLogger(ImpDomicilioDaoH2.class);

    @Override
    public Paciente save(Paciente paciente) {
        try {



            //1-Guardar el domicilio del paciente
            //Necesitamos el id del domicilio que se generara en la base de datos
            //insertar id en el campo domicilio_id en la tabla de pacientes
            Domicilio domicilio = impDomicilioDaoH2.save(paciente.getDomicilio());
            paciente.getDomicilio().setId(domicilio.getId());

            getConnection();

            //2 Crear una sentencia especificando que el ID lo autoincrementa la base de datos y que nos devuelva esa Key es decir el ID
            preparedStatement = connection.prepareStatement("INSERT INTO paciente (nombre, apellido, dni, fecha_ingreso, id_domicilio) VALUES(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            //No le vamos a pasar el ID ya que hicimos que fuera autoincremental en la base de datos
            //preparedStatement.setLong(1,paciente.getId());
            preparedStatement.setString(1, paciente.getNombre());
            preparedStatement.setString(2, paciente.getApellido());
            preparedStatement.setString(3, paciente.getDni());
            //Convertir el Date en sql ya que son dos clases diferentes en Java
            preparedStatement.setDate(4, Util.utilDateToSqlDate(paciente.getFechaIngreso()));
            //Tenemos que pasarle la clava foranea del ID del domicilio es decir el campo domicilio_id
            preparedStatement.setLong(5, paciente.getDomicilio().getId());

            //3 Ejecutar una sentencia SQL y obtener los ID que se autogeneren en la base de datos
            preparedStatement.executeUpdate();

            logger.info("logger info en el metodo guardar");

            ResultSet keys = preparedStatement.getGeneratedKeys();
            if (keys.next()){
                paciente.setId(keys.getLong(1));
            }
            preparedStatement.close();


       /* } catch ( ClassNotFoundException throwables) {
            throwables.printStackTrace();*/

        } catch (Exception e) {
            logger.error("este es un logger error" + e.getStackTrace());

        }
        return paciente;
    }

    @Override
    public Paciente findById(Long id) {

        Paciente paciente = null;

        try {
            //1 Levantar el driver y Conectarnos
            getConnection();
            //2 Crear una sentencia
            preparedStatement = connection.prepareStatement("SELECT id,nombre,apellido,dni,fecha_ingreso, id_domicilio FROM paciente where id = ?");
            preparedStatement.setLong(1, id);

            //3 Ejecutar la sentencia SQL
            ResultSet result = preparedStatement.executeQuery();

            //4 Obtener los Resultados
            while (result.next()){
                //Long idPaciente = result.getLong("id");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                String dni = result.getString("dni");
                Date fechaIngreso = result.getDate("fecha_ingreso");
                Long idDomicilio = result.getLong("id_domicilio");
                //Con el domicilio_id traemos el domicilio de la tabla domicilio a traves de DAO de domicilios
                Domicilio domicilio = impDomicilioDaoH2.findById(idDomicilio);
                paciente=new Paciente(nombre, apellido, dni, fechaIngreso, domicilio);
            }

            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paciente;
    }

    @Override
    public void deleteById(Long id) {

        try {
            //1 Levantar el driver y Conectarnos
            getConnection();

            //2 Crear una sentencia
            preparedStatement = connection.prepareStatement("DELETE FROM paciente where id = ?");
            preparedStatement.setLong(1,id);

            //3 Ejecutar una sentencia SQL
            preparedStatement.executeUpdate();
            System.out.println("Paciente eliminado");
            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Paciente> findAll() {

        List<Paciente> pacientes = new ArrayList<>();

        try {
            //1 Levantar el driver y Conectarnos
            getConnection();

            //2 Crear una sentencia
            preparedStatement = connection.prepareStatement("SELECT *  FROM paciente");

            //3 Ejecutar una sentencia SQL
            ResultSet result = preparedStatement.executeQuery();

            //4 Obtener resultados
            //4 Obtener resultados
            while (result.next()) {
                Paciente paciente = null;
                //Long idPaciente = result.getLong("id");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                String dni = result.getString("dni");
                Date fechaIngreso = result.getDate("fecha_ingreso");
                Long idDomicilio = result.getLong("id_domicilio");

                //Con el domicilio_id traemos el domicilio de la tabla domicilio a traves de DAO de Domicilios
                Domicilio domicilio = impDomicilioDaoH2.findById(idDomicilio);
               paciente = new Paciente(nombre,apellido,dni,fechaIngreso,domicilio);

                pacientes.add(paciente);
            }

            preparedStatement.close();

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pacientes;
    }
}
