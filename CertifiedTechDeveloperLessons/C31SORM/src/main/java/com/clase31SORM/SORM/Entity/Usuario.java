package com.clase31SORM.SORM.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
// me traigo los getters y setters de los atributos
@Getter
@Setter
// defino que es una tabla (DB)
@Table
// es una entidad (DB)
@Entity
// Constructores
@AllArgsConstructor
@NoArgsConstructor

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column
    private  String usuario;
    @Column
    private String password;
}
