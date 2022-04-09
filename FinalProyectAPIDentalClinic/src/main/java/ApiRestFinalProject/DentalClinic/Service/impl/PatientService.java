package ApiRestFinalProject.DentalClinic.Service.impl;

import ApiRestFinalProject.DentalClinic.DTO.PatientDTO;
import ApiRestFinalProject.DentalClinic.Repository.IPatientRepository;
import ApiRestFinalProject.DentalClinic.Service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements IPatientService {

    @Autowired
    private IPatientRepository iPatientRepository;


    public PatientService(IPatientRepository iPatientRepository) {
        this.iPatientRepository = iPatientRepository;
    }

    @Override
    public PatientDTO findById(Integer id) {
        return null;
    }

    @Override
    public PatientDTO create(PatientDTO patientDTO) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public PatientDTO update(PatientDTO patientDTO) {
        return null;
    }

    @Override
    public List<PatientDTO> findAll() {
        return null;
    }

    @Override
    public PatientDTO getPatientbyEmail(String email) {
        return null;
    }
}
