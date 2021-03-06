package ApiRestFinalProject.DentalClinic.DTO;

import ApiRestFinalProject.DentalClinic.Entities.Address;
import ApiRestFinalProject.DentalClinic.Entities.Appointment;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
public class PatientDTO {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private Integer dni;
    private LocalDate initDate = LocalDate.now();
    private AddressDTO address;



}
