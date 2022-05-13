package ApiRestFinalProject.DentalClinic.Controller;

import ApiRestFinalProject.DentalClinic.DTO.DentistDTO;
import ApiRestFinalProject.DentalClinic.DTO.PatientDTO;
import ApiRestFinalProject.DentalClinic.Service.impl.DentistService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@RestController
@RequestMapping("/dentists")
public class DentistController {

    //Para que me traiga y poder usar todo lo que tengo en DentistService
    @Autowired
    private final DentistService dentistService;

    @PostMapping("/register")
    public ResponseEntity<?> create(@RequestBody DentistDTO dentistDTO) {
        dentistService.create(dentistDTO);
        return ResponseEntity.ok(HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<DentistDTO> findDentistById( @PathVariable Integer id) {
        DentistDTO dentistDTO = dentistService.findById(id);
        return new ResponseEntity<>(dentistDTO, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody DentistDTO dentistDTO) {
        dentistService.update(dentistDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        dentistService.deleteById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/lists")
    public Collection<DentistDTO> findAll() {
        return dentistService.findAll();

    }
}
