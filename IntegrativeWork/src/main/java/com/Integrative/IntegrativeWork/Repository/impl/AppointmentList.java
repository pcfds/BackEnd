package com.Integrative.IntegrativeWork.Repository.impl;

import com.Integrative.IntegrativeWork.Domain.Appointment;
import com.Integrative.IntegrativeWork.Domain.Dentist;
import com.Integrative.IntegrativeWork.Domain.Patient;
import com.Integrative.IntegrativeWork.Repository.iDao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AppointmentList implements iDao<Appointment> {
    private List<Appointment> appointments;

    public AppointmentList() {
        appointments=new ArrayList<>();
        PatientDAOH2 patientDAOH2= new PatientDAOH2();
        DentistDAOH2 dentistDAOH2= new DentistDAOH2();
        Patient patient= patientDAOH2.search(1);
        Dentist dentist= dentistDAOH2.search(1);
        Appointment firstAppointment= new Appointment(1,patient,dentist, LocalDate.of(2022,03,01));
        appointments.add(firstAppointment);
    }

    @Override
    public Appointment register(Appointment appointment) {
        appointments.add(appointment);
        return appointment;


    }

    @Override
    public Appointment search(Integer id) {
        for (Appointment appointment: appointments){
            if (appointment.getId().equals(id)) {
                return appointment;
            }
        }
        return null;
    }

    @Override
    public Appointment searchEmail(String email) {
        return null;
    }

    @Override
    public Appointment update(Integer id, Appointment appointment) {
        update(appointment.getId(), appointment);
        appointments.add(appointment);
        return appointment;
    }

    @Override
    public void delete(Integer id) {
        for (Appointment appointment: appointments){
            if (appointment.getId().equals(id)){
                appointments.remove(appointment);
                return;
            }
        }

    }

    @Override
    public List<Appointment> searchAll() {
        return appointments;
    }
}
