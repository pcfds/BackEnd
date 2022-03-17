package ejercicePacientes;

import ejercicePacientes.dao.ImplPacienteDaoH2;
import ejercicePacientes.entities.Domicilio;
import ejercicePacientes.entities.Paciente;
import ejercicePacientes.services.PacienteService;

import java.util.Date;
import java.util.List;

public class Main {



    public static void main(String[] args) {

        //1-Creando entidades
        System.out.println("Agregando pacientes");
        Paciente paciente = new Paciente("Juan","Medina","43232443",new Date(),new Domicilio("HH","193","SP","Chaco"));
        Paciente paciente2 = new Paciente("Maximo","Hernandez","493823843",new Date(),new Domicilio("HR","200","SP","Chaco"));

        //2- Creando servicio
        PacienteService pacienteService = new PacienteService();
        //3- seteamos estrategia
        pacienteService.setPacienteIDao(new ImplPacienteDaoH2());

        pacienteService.guardar(paciente);
        System.out.println("name:" + pacienteService.buscar(paciente.getId()).getNombre());


        pacienteService.guardar(paciente2);
        System.out.println("name:" + pacienteService.buscar(paciente2.getId()).getNombre());

        System.out.println("--------------------------------------------");
        System.out.println("Lista de los pacientes con sus direcciones");
        List<Paciente> pacienteList = pacienteService.buscarTodos();
        for (Paciente paciente1 : pacienteList){
            System.out.println("name: "+ paciente1.getNombre()+ " direccion: "+ paciente1.getDomicilio().getCalle());
        }
    }
}
