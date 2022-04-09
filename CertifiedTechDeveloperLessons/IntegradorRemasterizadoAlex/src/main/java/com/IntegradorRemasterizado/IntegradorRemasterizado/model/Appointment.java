package com.IntegradorRemasterizado.IntegradorRemasterizado.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Appointments")
public class Appointment {

    @Id
    private Integer id;

    @Column
    private Integer idPatient;

    @Column
    private Integer idDentist;

    @Column
    private LocalDate date;
}
