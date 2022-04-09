package ApiRestFinalProject.DentalClinic.Service;

import ApiRestFinalProject.DentalClinic.DTO.PatientDTO;
import ApiRestFinalProject.DentalClinic.Service.ICRUDService;

public interface IPatientService extends ICRUDService<PatientDTO> {

    PatientDTO getPatientbyEmail(String email);
}
