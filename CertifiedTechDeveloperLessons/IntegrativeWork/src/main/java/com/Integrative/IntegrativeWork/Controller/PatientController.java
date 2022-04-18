package com.Integrative.IntegrativeWork.Controller;

import com.Integrative.IntegrativeWork.Domain.Dentist;
import com.Integrative.IntegrativeWork.Domain.Patient;
import com.Integrative.IntegrativeWork.Repository.impl.PatientDAOH2;
import com.Integrative.IntegrativeWork.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")

public class PatientController {


    @Autowired
    private PatientService patientService;


    @GetMapping("/{id}")
    public ResponseEntity<Patient> search(@PathVariable Integer id) {
        Patient patient = patientService.search(id);

        return ResponseEntity.ok(patient);
    }

    @GetMapping
    public ResponseEntity<List<Patient>> searchAll() {
        return ResponseEntity.ok(patientService.searchAll());
    }


        @PostMapping()
        public ResponseEntity<Patient> patientRegister(@RequestBody Patient patient) {

            return ResponseEntity.ok(patientService.register(patient));

        }

            @PutMapping()
            public ResponseEntity<Patient> update(@RequestBody Patient patient) {
                ResponseEntity<Patient> response = null;

                if (patient.getId() != null && patientService.search(patient.getId()) != null)
                response = ResponseEntity.ok(patientService.update(patient.getId(), patient));
            else
                response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

            return response;
        }

    }

