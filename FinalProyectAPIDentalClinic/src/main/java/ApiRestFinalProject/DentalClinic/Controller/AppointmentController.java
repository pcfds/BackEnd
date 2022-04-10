package ApiRestFinalProject.DentalClinic.Controller;

import ApiRestFinalProject.DentalClinic.DTO.AppointmentDTO;
import ApiRestFinalProject.DentalClinic.DTO.DentistDTO;
import ApiRestFinalProject.DentalClinic.DTO.PatientDTO;
import ApiRestFinalProject.DentalClinic.Service.impl.AppointmentService;
import ApiRestFinalProject.DentalClinic.Service.impl.DentistService;
import ApiRestFinalProject.DentalClinic.Service.impl.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/appointment")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private PatientService patientService;

    @Autowired
    private DentistService dentistService;

    @PostMapping("/register")
    public ResponseEntity<AppointmentDTO> create (@RequestBody AppointmentDTO appointmentDTO) {
        ResponseEntity<AppointmentDTO> response;


        PatientDTO patientBusDTO = patientService.findById(appointmentDTO.getPatient().getId());
        DentistDTO dentistBusDTO = dentistService.findById(appointmentDTO.getDentist().getId());

        if (patientBusDTO != null && dentistBusDTO != null) {
            response = ResponseEntity.ok(appointmentService.create(appointmentDTO));
       }
       else {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
       }
        return response;
    }

//    @GetMapping("/findAll")
//    public ResponseEntity<List<AppointmentDTO>> findAll() {
//        return ResponseEntity.ok(appointmentService.findAll());
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        ResponseEntity<String> response;
        //controlar el id
        if (appointmentService.findById(id)!=null){
            //existe
            appointmentService.deleteById(id);
            response= ResponseEntity.status(HttpStatus.OK).body("Turno con id = " + id + " eliminado");
        }
        else{
            response=ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro un turno con el id = " + id);
        }
        return response;
    }

}
