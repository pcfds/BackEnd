package com.Integrative.IntegrativeWork.Domain;

import java.util.Date;

public class Patient {

    private int patient_id;
    private String name;
    private String surname;
    private String address;
    private int dni;
    private Date dateInit;

    public Patient(int patient_id, String name, String surname, String address, int dni, Date dateInit) {
        this.patient_id = patient_id;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.dni = dni;
        this.dateInit = dateInit;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
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
                "patient_id=" + patient_id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", dni=" + dni +
                ", dateInit=" + dateInit +
                '}';
    }
}
