package ApiRestFinalProject.DentalClinic.Service.impl;

import ApiRestFinalProject.DentalClinic.DTO.PatientDTO;
import ApiRestFinalProject.DentalClinic.Service.IPatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class PatientServiceTest {

    @Autowired
    private IPatientService patientService;
    @Test
    public void testCreatePatient () {

       PatientDTO patientDTO = new PatientDTO();
       patientDTO.setName("Pedro");
       patientDTO.setSurname("Castro");
       patientService.create(patientDTO);

       PatientDTO patientPedro = patientService.findById(1);


       assertTrue( patientPedro != null);

    }

    @Test
    public void testDeletePatient(){
        PatientDTO patientDTO = new PatientDTO();
        patientDTO.setName("Pedro");
        patientDTO.setSurname("Castro");

        patientService.create(patientDTO);
        patientService.deleteById(1);

        PatientDTO patientPedro = patientService.findById(1);


        assertTrue( patientPedro == null);

    }

}