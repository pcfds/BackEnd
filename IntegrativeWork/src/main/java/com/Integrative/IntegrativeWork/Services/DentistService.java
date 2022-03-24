package com.Integrative.IntegrativeWork.Services;

import com.Integrative.IntegrativeWork.DAO.iDao;
import com.Integrative.IntegrativeWork.Domain.Dentist;


import java.util.List;

public class DentistService {
    private iDao<Dentist> dentistIdao;

    public DentistService(iDao<Dentist> dentistIdao) {
        this.dentistIdao = dentistIdao;
    }

    public iDao<Dentist> getDentistIdao() {
        return dentistIdao;
    }

    public void setDentistIdao(iDao<Dentist> dentistIdao) {
        this.dentistIdao = dentistIdao;
    }

    public Dentist register(Dentist dentist) {
        return dentistIdao.register(dentist);
    }

    public Dentist search(int id) {
        return dentistIdao.search(id);
    }

    public Dentist update(int id, Dentist dentist) {
        return dentistIdao.update(id, dentist);
    }

    public void delete(int id) {
        dentistIdao.delete(id);
    }

    public List<Dentist> searchAll() {
        return dentistIdao.searchAll();
    }
}
