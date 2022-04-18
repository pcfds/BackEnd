package com.Integrative.IntegrativeWork.Services;

import com.Integrative.IntegrativeWork.Domain.Appointment;
import com.Integrative.IntegrativeWork.Domain.Dentist;
import com.Integrative.IntegrativeWork.Repository.iDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class AppointmentService {

    private iDao<Appointment> appointmentiDao;

    public AppointmentService (iDao<Appointment> appointmentiDao) {
        this.appointmentiDao = appointmentiDao;
    }

    public iDao<Appointment> getAppointmentiDao() { return appointmentiDao; }

    public void setAppointmentiDao(iDao<Appointment> appointmentiDao) {
        this.appointmentiDao = appointmentiDao;
    }

    public Appointment register(Appointment appointment) {
        return appointmentiDao.register(appointment);
    }

    public Appointment search (Integer id) {
        return appointmentiDao.search(id);
    }

    public Appointment update (Integer id, Appointment appointment) {
        return appointmentiDao.update(id, appointment);
    }

    public void delete (Integer id) {
        appointmentiDao.delete(id);
    }

    public List<Appointment> searchAll() {
        return appointmentiDao.searchAll();
    }
}
