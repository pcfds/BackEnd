package com.IntegradorRemasterizado.IntegradorRemasterizado.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AppointmentDTO {
    private Integer id;

    private Integer idPatient;

    private Integer idDentist;

    private LocalDate date;


}
