package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Subject {

    @Id
    @GeneratedValue
    Long id;

    String name;
    String leader;

    /*@ManyToMany(mappedBy = "subjects")
    private Set<Student> students;*/
}
