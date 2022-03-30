package com.Integrative.IntegrativeWork.Services;

import com.Integrative.IntegrativeWork.Repository.iDao;
import com.Integrative.IntegrativeWork.Domain.Patient;

import java.util.List;

public class PatientService {

    private iDao<Patient> patientiDao;

    public PatientService(iDao<Patient> patientiDao) {
        this.patientiDao = patientiDao;
    }

    public iDao<Patient> getPatientiDao() {
        return patientiDao;
    }

    public void setPatientiDao(iDao<Patient> patientiDao) {
        this.patientiDao = patientiDao;
    }

    public Patient register(Patient patient) {
        return patientiDao.register(patient);
    }

    public Patient search(Integer id) {
        return patientiDao.search(id);
    }

    public Patient update(Integer id, Patient patient) {
        return patientiDao.update(id,patient);
    }

    public void delete(Integer id) {
        patientiDao.delete(id);
    }

    public List<Patient> searchAll() {
        return patientiDao.searchAll();
    }


}
