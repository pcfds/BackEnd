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
public class PatientDTO {
    private Integer id;

    private String name;

    private String surName;

    private String email;

    private LocalDate admissionDate;
}
