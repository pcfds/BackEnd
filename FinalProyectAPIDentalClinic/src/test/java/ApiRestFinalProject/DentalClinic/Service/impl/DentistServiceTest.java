package ApiRestFinalProject.DentalClinic.Service.impl;

import ApiRestFinalProject.DentalClinic.DTO.DentistDTO;
import ApiRestFinalProject.DentalClinic.DTO.PatientDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DentistServiceTest {

    @Autowired
   private DentistService dentistService;

    @Test


    public void testCreateDentist(){
        DentistDTO dentistDTO = new DentistDTO();
        dentistDTO.setId(1);
        dentistDTO.setName("Pedro");
        dentistDTO.setSurname("Perez");
        dentistDTO.setRegister(456);
        dentistService.create(dentistDTO);

        dentistService.findById(dentistDTO.getId());

        assertEquals(dentistService.findById(dentistDTO.getId()).getName(),"Pedro");

    }

    @Test
    public void testDeleteDentist(){
        DentistDTO dentistDTO = new DentistDTO();
        dentistDTO.setName("Pedro");
        dentistDTO.setSurname("Perez");
        dentistDTO.setRegister(456);

        dentistService.create(dentistDTO);
        dentistService.deleteById(1);

        DentistDTO dentistTest = dentistService.findById(1);

        assertNull(dentistTest);
    }

    @Test
    public void testFindById() {
        DentistDTO dentistDTO = new DentistDTO();
        dentistDTO.setName("Pedro");
        dentistDTO.setSurname("Perez");
        dentistDTO.setRegister(456);
        dentistService.create(dentistDTO);

        dentistService.findById(1);

        assertTrue(dentistService.findById(1).getName().equals("Pedro"));
    }

    @Test
    public void testUpdateDentist(){
        DentistDTO dentistDTO = new DentistDTO();
        dentistDTO.setName("Pedro");
        dentistDTO.setSurname("Perez");
        dentistDTO.setRegister(456);
        dentistService.create(dentistDTO);

        dentistService.update(dentistDTO);

        assertEquals("Pedro", dentistService.findById(1).getName());
    }

    @Test
    public void testFindAll(){
        DentistDTO dentistDTO = new DentistDTO();
        dentistDTO.setName("Pedro");
        dentistDTO.setSurname("Perez");
        dentistDTO.setRegister(456);
        dentistService.create(dentistDTO);

        dentistService.findAll();

        assertTrue(dentistService.findAll().size()>0);
    }






}