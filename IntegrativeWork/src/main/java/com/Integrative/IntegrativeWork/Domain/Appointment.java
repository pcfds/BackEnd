package com.Integrative.IntegrativeWork.Domain;

import java.util.Date;

public class Appointment {

    private Integer id;
    private Patient patient;
    private Dentist dentist;
    private Date date;

    public Appointment(int id, Dentist dentist, Patient patient, Date date) {
        this.id = id;
        this.dentist = dentist;
        this.patient = patient;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id_appointment=" + id +
                ", Dentist=" + dentist +
                ", patient=" + patient +
                ", date=" + date +
                '}';
    }
}
