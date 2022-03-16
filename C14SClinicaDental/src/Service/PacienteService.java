package Service;

import DAO.iDao;
import model.Paciente;

public class PacienteService {
    private iDao<Paciente> pacienteDao;

    public PacienteService(){

    }

    public PacienteService(iDao<Paciente> pacienteDao) {
        this.pacienteDao = pacienteDao;
    }

    public void setPacienteDao(iDao<Paciente> pacienteDao) {
        this.pacienteDao = pacienteDao;
    }
}
