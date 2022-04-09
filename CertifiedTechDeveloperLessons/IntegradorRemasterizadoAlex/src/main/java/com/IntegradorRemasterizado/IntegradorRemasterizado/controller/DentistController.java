package com.IntegradorRemasterizado.IntegradorRemasterizado.controller;

import com.IntegradorRemasterizado.IntegradorRemasterizado.DTO.DentistDTO;
import com.IntegradorRemasterizado.IntegradorRemasterizado.service.impl.DentistService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/dentist")
public class DentistController {

    //Para que me traiga y poder usar todo lo que tengo en DentistService
    @Autowired
    private final DentistService dentistService;

    @PostMapping("/register")
    public ResponseEntity<DentistDTO> registerDentist(@RequestBody DentistDTO dentistDTO) {
        DentistDTO dDTO = dentistService.registerDentist(dentistDTO);
        return new ResponseEntity<>(dDTO, HttpStatus.OK);
      //  return ResponseEntity.ok(dentistService.registerDentist(dDTO)); //no entieno

    }

    @GetMapping("/find/{id}")
    public ResponseEntity<DentistDTO> findById(@PathVariable("id") Integer id) { //Que me compare con la columna id, el integer id
        DentistDTO dDTO = dentistService.findById(id);

        // return new ResponseEntity<>(odontologoDTO, HttpStatus.OK);
        //Poruqe esta asi??
        return ResponseEntity.ok(dDTO);
    }

   /* @PutMapping()
    public ResponseEntity<DentistDTO> update(@RequestBody DentistDTO dentistDTO) {
        ResponseEntity<DentistDTO> response = null;

        if (dentistDTO.getId() != null && dentistService.findById(dentistDTO.getId()) != null)
            response = ResponseEntity.ok(dentistService.update(dentistDTO));
        else
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return response;
    }*/

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDentist(@PathVariable("id") Integer id) {
        ResponseEntity<String> response = null;

        if (dentistService.findById(id) != null) {
            dentistService.deleteById(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return response;
    }

    /*@GetMapping("/findAll")
    public ResponseEntity<List<Dentist>> findAll(){
        return ResponseEntity.ok(dentistService.findAll());
    }*/

    @GetMapping("/findAll")
    public List<DentistDTO> findAllDentist(){
        return dentistService.findAll();
    }

}
