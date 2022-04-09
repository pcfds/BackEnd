package com.IntegradorRemasterizado.IntegradorRemasterizado.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String email;

    @Column
    private String identityNumber;

    @Column
    private LocalDate admissionDate;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "idAdress", referencedColumnName = "id")
    private Adress adress;

    @ManyToMany
    @JoinTable(name = "Appointments",
            joinColumns = @JoinColumn (name = "idPatient"),
            inverseJoinColumns = @JoinColumn (name = "idDentist"))
    private List<Appointment> appointments;




}
