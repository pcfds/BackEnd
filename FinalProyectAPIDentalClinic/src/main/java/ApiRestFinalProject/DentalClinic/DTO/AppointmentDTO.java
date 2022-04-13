package ApiRestFinalProject.DentalClinic.DTO;

import ApiRestFinalProject.DentalClinic.Entities.Dentist;
import ApiRestFinalProject.DentalClinic.Entities.Patient;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;

@Data
public class AppointmentDTO {

    private Integer id;
    private Patient patient;
    private Dentist dentist;
    private LocalDate date;
    private Time time;


}
