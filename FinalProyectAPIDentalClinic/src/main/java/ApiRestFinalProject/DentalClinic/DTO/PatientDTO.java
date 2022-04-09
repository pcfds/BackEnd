package ApiRestFinalProject.DentalClinic.DTO;

import ApiRestFinalProject.DentalClinic.Entities.Address;

import javax.persistence.Column;
import java.time.LocalDate;

public class PatientDTO {
    private Integer id;
    private String name;
    private String surname;
    private String email;
    private int dni;
    private LocalDate initDate;
    private Address Address;

}
