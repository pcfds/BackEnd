package ApiRestFinalProject.DentalClinic.Controller;

import ApiRestFinalProject.DentalClinic.DTO.PatientDTO;
import ApiRestFinalProject.DentalClinic.Service.impl.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/patient")
public class PatientController {

    //Para que me traiga y poder usar todo lo que tengo en PatientService
    @Autowired
    private final PatientService patientService;

    @PostMapping("/register")
    public ResponseEntity<PatientDTO> create (@RequestBody PatientDTO patientDTO) {
        PatientDTO pDTO = patientService.create(patientDTO);
        return new ResponseEntity<>(pDTO, HttpStatus.OK);
        //return ResponseEntity.ok(patientService.registerPatient(patient));

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<PatientDTO> findById(@PathVariable("id") Integer id) {
        PatientDTO pDTO = patientService.findById(id);
        return new ResponseEntity<>(pDTO, HttpStatus.OK);
        //return ResponseEntity.ok(pDTO);
    }

    @PutMapping()
    public ResponseEntity<PatientDTO> update (@RequestBody PatientDTO patientDTO) {
        ResponseEntity<PatientDTO> response = null;

        //Si el id no es nulo y si ese paciente existe....
        if (patientDTO.getId() != null && patientService.findById(patientDTO.getId()) != null) {
            //Me actualiza
            response = ResponseEntity.ok(patientService.update(patientDTO));
        }
        else {
            //Me tira error
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable("id") Integer id) {
        ResponseEntity<String> response = null;

        if (patientService.findById(id) != null) {
            patientService.deleteById(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }
//
//    @GetMapping("/findAll")
////    public Set<PatientDTO> findAllPatients(){
////        return patientService.findAll();
////    }

}
