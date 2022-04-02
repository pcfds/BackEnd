package com.Integrative.IntegrativeWork.Controller;

import com.Integrative.IntegrativeWork.Domain.Patient;
import com.Integrative.IntegrativeWork.Repository.impl.PatientDAOH2;
import com.Integrative.IntegrativeWork.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/patients")

public class PatientController {


    private PatientService patientService = new PatientService(new PatientDAOH2());

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

