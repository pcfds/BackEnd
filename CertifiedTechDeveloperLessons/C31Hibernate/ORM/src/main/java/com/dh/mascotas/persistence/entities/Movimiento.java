package com.dh.mascotas.persistence.entities;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


// esto trae Getter, Setter y To String
// @Data

@Getter
@Setter

@Entity
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column
    private String descripcion;
    @Column
    private String monto;

    // se pueden llamar con Getter y Setter de Lombok

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMonto() {
        return monto;
    }

    public void setMonto(String monto) {
        this.monto = monto;
    }


}
