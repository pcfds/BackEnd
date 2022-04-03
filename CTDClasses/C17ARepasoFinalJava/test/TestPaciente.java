import ejercicePacientes.dao.IDao;
import ejercicePacientes.dao.ImplPacienteDaoH2;
import ejercicePacientes.entities.Domicilio;
import ejercicePacientes.entities.Paciente;
import ejercicePacientes.services.PacienteService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class TestPaciente {

    private IDao<Paciente> pacienteIDao = new ImplPacienteDaoH2();
    private PacienteService pacienteService = new PacienteService();

    @Before
    public void cargarPacienteConSuDomicilioYGuardarlos(){
        Paciente paciente = new Paciente("Juan","Medina","43232443",new Date(),new Domicilio("HH","193","SP","Chaco"));
        Paciente paciente2 = new Paciente("Maximo","Hernandez","493823843",new Date(),new Domicilio("HR","200","SP","Chaco"));

        System.out.println("Id paciente 1: "+ paciente.getId());
        pacienteService.setPacienteIDao(pacienteIDao);
        pacienteService.guardar(paciente);
        pacienteService.guardar(paciente2);
    }

    @Test
    public void buscarPaciente(){

        pacienteService.setPacienteIDao(pacienteIDao);
        Paciente paciente = pacienteService.buscar(6L);
        Assert.assertEquals(paciente.getNombre(),"Maximo");
        Assert.assertEquals(paciente.getApellido(),"Hernandez");

    }
}
