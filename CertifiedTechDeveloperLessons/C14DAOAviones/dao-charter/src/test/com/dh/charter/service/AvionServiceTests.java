package test.com.dh.charter.service;

import main.com.dh.charter.dao.impl.AvionDaoH2;
import main.com.dh.charter.model.Avion;
import main.com.dh.charter.service.AvionService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import java.util.Date;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnit4.class)
public class AvionServiceTests {

    private static AvionService avionService =new AvionService(new AvionDaoH2());

    @BeforeClass
    public static void cargarDataSetAviones(){
        Avion airbus = new Avion("Airbus","319","abscbasf1243",new Date());
        Avion boeign = new Avion("Boeign","737","1234basf1430",new Date());
        avionService.registrarAvion(airbus);
        avionService.registrarAvion(boeign);

    }
    @Test
    public void buscarAvionTest() {
        Assert.assertTrue(avionService.buscarAvion(2) != null);
    }
    @Test
    public void eliminarAvionTest(){
        avionService.eliminar(1);
        Assert.assertTrue(avionService.buscarAvion(1) == null);
    }
    @Test
    public void traerTodos(){
        List<Avion> aviones = avionService.buscarTodos();
        Assert.assertTrue(!aviones.isEmpty());
        Assert.assertTrue(aviones.size() > 0);

    }




}
