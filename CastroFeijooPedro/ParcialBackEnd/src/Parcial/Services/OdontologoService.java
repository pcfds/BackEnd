package Parcial.Services;

import Parcial.DAO.iDao;
import Parcial.Models.Odontologo;

import java.util.List;

public class OdontologoService {
    private iDao<Odontologo> odontologoiDao;

    public OdontologoService(iDao<Odontologo> odontologoiDao) {
        this.odontologoiDao = odontologoiDao;
    }

    public Odontologo guardar(Odontologo p){
        return odontologoiDao.guardar(p);
    }
    public Odontologo buscar(int id) {return odontologoiDao.buscar(id);}
    public List<Odontologo> buscarTodos(){
        return odontologoiDao.buscarTodos();
    }
    public void eliminar(int id){
        odontologoiDao.eliminar(id);
    }



}
