package ApiRestFinalProject.DentalClinic.Controller;


import ApiRestFinalProject.DentalClinic.DTO.PatientDTO;
import ApiRestFinalProject.DentalClinic.Entities.Patient;
import ApiRestFinalProject.DentalClinic.GlobalExceptionHandler;
import ApiRestFinalProject.DentalClinic.Service.impl.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;


@AllArgsConstructor
@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    PatientService patientService;

        @PostMapping("/register")
        public ResponseEntity<?> create (@RequestBody PatientDTO patientDTO) {
            patientService.create(patientDTO);
            return ResponseEntity.ok(HttpStatus.OK);

        }



        @GetMapping("/{id}")
        public ResponseEntity<PatientDTO> findPatientById(@PathVariable Integer id) {
             PatientDTO patientDTO  = patientService.findById(id);
            return new ResponseEntity<>(patientDTO, HttpStatus.OK);
        }

        @PutMapping("/update")
        public ResponseEntity<?> update (@RequestBody PatientDTO patientDTO) {
            patientService.update(patientDTO);
            return ResponseEntity.ok(HttpStatus.OK);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<?> delete (@PathVariable Integer id) {
            patientService.deleteById(id);
            return ResponseEntity.ok(HttpStatus.OK);
        }

        @GetMapping("/lists")
        public Collection<PatientDTO> findAll() {
            return patientService.findAll();

        }
}



