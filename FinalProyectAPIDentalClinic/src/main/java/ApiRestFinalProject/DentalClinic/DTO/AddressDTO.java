package ApiRestFinalProject.DentalClinic.DTO;

import ApiRestFinalProject.DentalClinic.Entities.Patient;
import lombok.Data;

@Data
public class AddressDTO {

    private Integer id;
    private String street;
    private Integer number;
    private String city;



}
