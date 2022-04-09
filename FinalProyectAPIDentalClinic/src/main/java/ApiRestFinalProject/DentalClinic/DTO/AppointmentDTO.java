package ApiRestFinalProject.DentalClinic.DTO;

import ApiRestFinalProject.DentalClinic.Entities.Dentist;
import ApiRestFinalProject.DentalClinic.Entities.Patient;

import java.sql.Date;

public class AppointmentDTO {

    private Integer id;
    private Patient patient;
    private Dentist dentist;
    private Date Date;

}
