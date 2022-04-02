package com.Integrative.IntegrativeWork.Controller;

import com.Integrative.IntegrativeWork.Domain.Dentist;
import com.Integrative.IntegrativeWork.Repository.impl.DentistDAOH2;
import com.Integrative.IntegrativeWork.Repository.impl.PatientDAOH2;
import com.Integrative.IntegrativeWork.Services.DentistService;
import com.Integrative.IntegrativeWork.Services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/dentists")

public class DentistController {


    private DentistService dentistService = new DentistService(new DentistDAOH2());

    @PostMapping()
    public ResponseEntity<Dentist> registerDentist(@RequestBody Dentist dentist) {

        return ResponseEntity.ok(dentistService.register(dentist));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Dentist> search(@PathVariable Integer id) {
        Dentist dentist = dentistService.search(id);

        return ResponseEntity.ok(dentist);
    }

    @PutMapping()
    public ResponseEntity<Dentist> update(@RequestBody Dentist dentist) {
        ResponseEntity<Dentist> response = null;

        if (dentist.getId() != null && dentistService.search(dentist.getId())!= null)
            response = ResponseEntity.ok(dentistService.update(dentist.getId(), dentist));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        ResponseEntity<String> response = null;

        if (dentistService.search(id) != null) {
            dentistService.delete(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }
    @GetMapping
    public ResponseEntity<List<Dentist>> searchAll(){
        return ResponseEntity.ok(dentistService.searchAll());
    }
}
