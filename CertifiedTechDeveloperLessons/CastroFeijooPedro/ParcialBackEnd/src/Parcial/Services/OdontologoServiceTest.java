package Parcial.Services;

import Parcial.DAO.impl.OdontologoDAOH2;
import Parcial.Models.Odontologo;
import Parcial.Services.OdontologoService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


import java.util.Date;
import java.util.List;

import java.util.Date;
import java.util.List;

public class OdontologoServiceTest {


    private static OdontologoService odontologoService = new OdontologoService(new OdontologoDAOH2());

    @BeforeClass
    public static void cargarDataSet() {

        Odontologo o = odontologoService.guardar(new Odontologo(23, "Pedro", "Castro"));
        Odontologo o1 = odontologoService.guardar(new Odontologo(24, "Peter", "Bauman"));
        Odontologo o2 = odontologoService.guardar(new Odontologo(25, "Juan", "Perez"));
        Odontologo o3 = odontologoService.guardar(new Odontologo(12, "Eliseo", "Juarez"));

    }

    @Test
    public void agregarYBuscarOdontologoTest() {

        Odontologo o = odontologoService.guardar(new Odontologo(23, "Pedro", "Castro"));

        Assert.assertNotNull(odontologoService.buscar(o.getId()));
    }

    @Test
    public void eliminarOdontologoTest() {
        odontologoService.eliminar(1);
        Assert.assertTrue(odontologoService.buscar(1) == null);

    }

    @Test
    public void traerTodos() {
        List<Odontologo> odontologos = odontologoService.buscarTodos();
        Assert.assertFalse(odontologos.isEmpty());
        Assert.assertTrue(odontologos.size() > 1);
        System.out.println(odontologos);
    }
}
