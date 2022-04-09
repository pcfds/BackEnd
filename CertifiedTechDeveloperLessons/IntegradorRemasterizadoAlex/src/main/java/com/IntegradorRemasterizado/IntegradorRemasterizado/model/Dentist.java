package com.IntegradorRemasterizado.IntegradorRemasterizado.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table (name = "Dentists")
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String surName;

    @Column
    private String email;

    @Column
    private Integer enrollment;

    //Todavia no hicieron las relaciones
    @OneToMany (cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    private List<Patient> patients;

    @Override
    public String toString() {
        return "Dentist{" +
                "Id=" + id +
                ", Name='" + name + '\'' +
                ", Surname='" + surName + '\'' +
                ", Enrollment ='" + enrollment + '\'' +
                ", Email ='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dentist dentist = (Dentist) o;
        return Objects.equals(id, dentist.id) && Objects.equals(name, dentist.name) && Objects.equals(surName, dentist.surName) && Objects.equals(email, dentist.email) && Objects.equals(enrollment, dentist.enrollment) && Objects.equals(patients, dentist.patients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surName, email, enrollment, patients);
    }
}
