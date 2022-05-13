package ApiRestFinalProject.DentalClinic.DTO;

import ApiRestFinalProject.DentalClinic.Entities.Appointment;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class DentistDTO {

    private Integer id;
    private String name;
    private String surname;
    private Integer register;
}



