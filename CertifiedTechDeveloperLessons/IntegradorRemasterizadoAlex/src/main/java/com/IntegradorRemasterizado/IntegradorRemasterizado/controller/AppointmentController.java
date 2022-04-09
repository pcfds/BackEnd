package com.IntegradorRemasterizado.IntegradorRemasterizado.controller;

import com.IntegradorRemasterizado.IntegradorRemasterizado.DTO.AppointmentDTO;
import com.IntegradorRemasterizado.IntegradorRemasterizado.DTO.DentistDTO;
import com.IntegradorRemasterizado.IntegradorRemasterizado.DTO.PatientDTO;
import com.IntegradorRemasterizado.IntegradorRemasterizado.model.Appointment;
import com.IntegradorRemasterizado.IntegradorRemasterizado.model.Dentist;
import com.IntegradorRemasterizado.IntegradorRemasterizado.model.Patient;
import com.IntegradorRemasterizado.IntegradorRemasterizado.service.impl.AppointmentService;
import com.IntegradorRemasterizado.IntegradorRemasterizado.service.impl.DentistService;
import com.IntegradorRemasterizado.IntegradorRemasterizado.service.impl.PatientService;
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
    public ResponseEntity<AppointmentDTO> registerAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        ResponseEntity<AppointmentDTO> response;

        //preguntar si es un paciente correcto y un odontologo correcto
        PatientDTO patientBusDTO = patientService.findById(appointmentDTO.getIdPatient());
        DentistDTO dentistBusDTO = dentistService.findById(appointmentDTO.getIdDentist());

        if (patientBusDTO != null && dentistBusDTO != null) {
            response = ResponseEntity.ok(appointmentService.registerAppointment(appointmentDTO));
        }
        else {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<AppointmentDTO>> findAll() {
        return ResponseEntity.ok(appointmentService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id){
        ResponseEntity<String> response;
        //controlar el id
        if (appointmentService.findById(id)!=null){
            //existe
            appointmentService.delete(id);
            response= ResponseEntity.status(HttpStatus.OK).body("Turno con id = " + id + " eliminado");
        }
        else{
            response=ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontro un turno con el id = " + id);
        }
        return response;
    }

}
