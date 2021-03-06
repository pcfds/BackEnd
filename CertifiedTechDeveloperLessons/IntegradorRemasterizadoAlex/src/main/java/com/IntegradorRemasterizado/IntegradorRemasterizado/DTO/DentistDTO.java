package com.IntegradorRemasterizado.IntegradorRemasterizado.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DentistDTO {
    private Integer id;

    private String name;

    private String surName;

    private String email;

    private Integer enrollment;
}
