package com.Integrative.IntegrativeWork.Domain;

import java.util.Date;

public class Patient {

    private int id_patient;
    private String name;
    private String surname;
    private Address address;
    private int dni;
    private Date dateInit;

    public Patient(int id_patient, String name, String surname, Address address, int dni, Date dateInit) {
        this.id_patient = id_patient;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.dni = dni;
        this.dateInit = dateInit;
    }

    public int getId_patient() {
        return id_patient;
    }

    public void setId_patient(int id_patient) {
        this.id_patient = id_patient;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public Date getDateInit() {
        return dateInit;
    }

    public void setDateInit(Date dateInit) {
        this.dateInit = dateInit;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patient_id=" + id_patient +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", dni=" + dni +
                ", dateInit=" + dateInit +
                '}';
    }
}
