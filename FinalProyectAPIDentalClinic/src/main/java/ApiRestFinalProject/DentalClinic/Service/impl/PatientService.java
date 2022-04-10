package ApiRestFinalProject.DentalClinic.Service.impl;

;
import ApiRestFinalProject.DentalClinic.DTO.PatientDTO;
import ApiRestFinalProject.DentalClinic.Entities.Patient;
import ApiRestFinalProject.DentalClinic.Repository.IPatientRepository;
import ApiRestFinalProject.DentalClinic.Service.IPatientService;
import com.sun.istack.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class PatientService implements IPatientService {
    @Autowired
    private IPatientRepository iPatientRepository;
    @Autowired
    private ModelMapper modelMapper;

    //------ MAPPER----
    private PatientDTO mapDTO(Patient patient){
        PatientDTO patientDTO = modelMapper.map(patient, PatientDTO.class);
        return patientDTO;
    }

    private Patient mapEntity(PatientDTO patientDTO){
        Patient newPatient  = modelMapper.map(patientDTO, Patient.class);
        return newPatient;
    }
    @Override
    public PatientDTO create (PatientDTO patientDTO) {
        //1. Lo tengo que pasar de DTO a entidad.
        Patient patient = mapEntity(patientDTO);

        //2. Lo guardo en la bd.
        Patient patientSave = iPatientRepository.save(patient);

        //3. Lo vuelvo a convertir a DTO y la retorno
        return mapDTO(patientSave);
    }
 @Override
    public PatientDTO findById(@NotNull Integer id) {
        Patient patient = iPatientRepository.findById(id).orElse(null);
        return mapDTO(patient);

//        Patient patient = iPatientRepository.getById(id);
//        PatientDTO pDTO = mapDTO(patient);
//        return pDTO;
    }

    public List<PatientDTO> findAll() {
        //1. Creo una lista de todos los pacientes que hay
        List<Patient> patientsList = iPatientRepository.findAll();

        //2. Los paso a DTO para retornarlos
        List<PatientDTO> patientsDTOList = patientsList.stream().map(p -> mapDTO(p)).collect(Collectors.toList());
        return patientsDTOList;
    }

    public void deleteById(@NotNull Integer id ) {
        // 1. Buscar la entidad
        Patient patient = iPatientRepository.getById(id);
        // 2. Verficar que se encontro
        // 3. Elimino el ojeto paciente entero
        iPatientRepository.delete(patient);
    }

    public PatientDTO update(PatientDTO patientDTO) {
        //1. Casteo el pacienteDTO a paciente
        Patient patient = mapEntity(patientDTO);

        //2. Lo guardo al nuevo paciente
        Patient newPatient = iPatientRepository.save(patient);

        //3. Lo casteo a DTO y lo retorno
        return mapDTO(newPatient);
    }

}
