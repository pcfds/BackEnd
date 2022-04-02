package com.Integrative.IntegrativeWork.Controller;

import com.Integrative.IntegrativeWork.Domain.Appointment;
import com.Integrative.IntegrativeWork.Domain.Dentist;
import com.Integrative.IntegrativeWork.Domain.Patient;
import com.Integrative.IntegrativeWork.Repository.impl.AppointmentList;
import com.Integrative.IntegrativeWork.Repository.impl.DentistDAOH2;
import com.Integrative.IntegrativeWork.Repository.impl.PatientDAOH2;
import com.Integrative.IntegrativeWork.Services.AppointmentService;
import com.Integrative.IntegrativeWork.Services.DentistService;
import com.Integrative.IntegrativeWork.Services.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")

public class AppointmentController {

    private PatientService patientService = new PatientService(new PatientDAOH2());
    private DentistService dentistService = new DentistService(new DentistDAOH2());
    private AppointmentService appointmentService = new AppointmentService(new AppointmentList());

    @GetMapping
    public ResponseEntity<List<Appointment>> searchAll() {
        return ResponseEntity.ok(appointmentService.searchAll());
    }

    @PostMapping
    public ResponseEntity<Appointment> registerAppointment (@RequestBody Appointment appointment) {
        ResponseEntity<Appointment> response;
        //preguntar si es un paciente correcto y un odontologo correcto
        Patient searchPatient = patientService.search(appointment.getPatient().getId());
        Dentist searchDentist = dentistService.search(appointment.getDentist().getId());

        if (searchPatient != null && searchPatient != null) {
            response = ResponseEntity.ok(appointmentService.register(appointment));
        } else {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete (@PathVariable int id) {
        ResponseEntity<String> response;
        //controlar el id
        if (appointmentService.search(id) != null) {
            //existe
            appointmentService.delete(id);
            response = ResponseEntity.status(HttpStatus.OK).body("Appointment with id=" + id + " deleted");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("The next ID was not found =" + id);
        }
        return response;
    }

}
