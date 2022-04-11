package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Students")
@Getter @Setter
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String lastname;

    /*@ManyToMany(cascade = CascadeType.ALL)
    @OrderBy("name ASC")*/

    @ManyToMany
    @JoinTable(
            name = "STUDENTS_SUBJECTS",
            joinColumns = @JoinColumn(name = "STUDENTS_ID"),
            inverseJoinColumns = @JoinColumn(name = "SUBJECTS_ID")
    )
    private Set<Subject> subjects;


}
