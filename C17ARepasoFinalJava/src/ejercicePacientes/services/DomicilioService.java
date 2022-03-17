package ejercicePacientes.services;

import ejercicePacientes.dao.IDao;
import ejercicePacientes.entities.Domicilio;

import java.util.List;

public class DomicilioService{

    private IDao<Domicilio> domicilioIDao;

    public DomicilioService(IDao<Domicilio> domicilioIDao) {
        this.domicilioIDao = domicilioIDao;
    }

    public Domicilio guardar(Domicilio p){
        return domicilioIDao.save(p);
    }

    public Domicilio buscar(Long id){
        return domicilioIDao.findById(id);
    }

    public void eliminar(Long id){
        domicilioIDao.deleteById(id);
    }

    public List<Domicilio> buscarTodos(){
        return domicilioIDao.findAll();
    }
}
