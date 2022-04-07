package ApiRestFinalProject.DentalClinic.Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "address")

public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String street;
    @Column
    private Integer number;
    @Column
    private String city;
    @OneToOne(mappedBy = "address")
    private Patient patient;

}
