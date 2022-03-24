package com.Integrative.IntegrativeWork.Domain;

import java.util.Date;

public class Appointment {

    private int id_appointment;
    private Patient patient;
    private Dentist dentist;
    private Date date;

    public Appointment(int id_appointment, Dentist dentist, Patient patient, Date date) {
        this.id_appointment = id_appointment;
        this.dentist = dentist;
        this.patient = patient;
        this.date = date;
    }

    public int getId_appointment() {
        return id_appointment;
    }

    public void setId_appointment(int id_appointment) {
        this.id_appointment = id_appointment;
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
                "id_appointment=" + id_appointment +
                ", Dentist=" + dentist +
                ", patient=" + patient +
                ", date=" + date +
                '}';
    }
}
