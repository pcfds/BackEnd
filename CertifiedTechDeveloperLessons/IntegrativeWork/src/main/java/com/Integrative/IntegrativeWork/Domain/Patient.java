package com.Integrative.IntegrativeWork.Domain;

import java.time.LocalDate;

public class Patient {

    private Integer id;
    private String name;
    private String surname;
    private String email;
    private int dni;
    private LocalDate initDate;
    private Address address;

    private Patient(){

    }

    public Patient(Integer id, String name, String surname, String email, int dni, LocalDate initDate, Address address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.dni = dni;
        this.initDate = initDate;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public LocalDate getInitDate() {
        return initDate;
    }

    public void setInitDate(LocalDate initDate) {
        this.initDate = initDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", dni=" + dni +
                ", initDate=" + initDate +
                ", address=" + address +
                '}';
    }
}
