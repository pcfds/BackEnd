package ApiRestFinalProject.DentalClinic.DTO;

import ApiRestFinalProject.DentalClinic.Entities.Address;
import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDate;
@Data
public class PatientDTO {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private AddressDTO address;

}
