package ApiRestFinalProject.DentalClinic.Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "dentist")

public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;
    private String surname;
    private String register;
    @OneToMany(mappedBy = "dentist", fetch = FetchType.LAZY)
    private Set<Appointment> appointments = new HashSet<>();


}
