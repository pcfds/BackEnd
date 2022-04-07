package clinica.dh.controller;

import clinica.dh.dto.OdontologoDTO;
import clinica.dh.service.impl.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/odontologos")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    @GetMapping("/{id}")
    public ResponseEntity<OdontologoDTO> findById(@PathVariable("id") Integer id) {
        OdontologoDTO odontologoDTO = odontologoService.findById(id);
        return new ResponseEntity<>(odontologoDTO, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<OdontologoDTO> create(@RequestBody OdontologoDTO odontologoDTO) {
        OdontologoDTO newOdontologoDTO = odontologoService.create(odontologoDTO);
        return new ResponseEntity<>(newOdontologoDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteByid(@PathVariable("id") Integer id) {
        odontologoService.deleteById(id);
        return new ResponseEntity<>("Odontologo eliminado", HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<OdontologoDTO> update(@RequestBody OdontologoDTO odontologoDTO) {
        OdontologoDTO newOdontologoDTO = odontologoService.update(odontologoDTO);
        return new ResponseEntity<>(newOdontologoDTO, HttpStatus.OK);
    }

    @GetMapping("/List")
    public ResponseEntity<List<OdontologoDTO>> findAll() {
        List<OdontologoDTO> odontologoDTOList = odontologoService.findAll();
        return new ResponseEntity<>(odontologoDTOList, HttpStatus.OK);
    }   
}

