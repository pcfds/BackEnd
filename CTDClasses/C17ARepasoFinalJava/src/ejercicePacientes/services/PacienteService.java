package ejercicePacientes.services;

import ejercicePacientes.dao.IDao;
import ejercicePacientes.entities.Paciente;

import java.util.List;

public class PacienteService {

    private IDao<Paciente> pacienteIDao;



    public void setPacienteIDao(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    public Paciente guardar(Paciente p){

        return pacienteIDao.save(p);
    }

    public Paciente buscar(Long id){
        return pacienteIDao.findById(id);
    }

    public void eliminar(Long id){
        pacienteIDao.deleteById(id);
    }

    public List<Paciente> buscarTodos(){
        return pacienteIDao.findAll();
    }
}
