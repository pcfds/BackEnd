package com.IntegradorRemasterizado.IntegradorRemasterizado.service.impl;

import com.IntegradorRemasterizado.IntegradorRemasterizado.DTO.DentistDTO;
import com.IntegradorRemasterizado.IntegradorRemasterizado.DTO.PatientDTO;
import com.IntegradorRemasterizado.IntegradorRemasterizado.model.Dentist;
import com.IntegradorRemasterizado.IntegradorRemasterizado.model.Patient;
import com.IntegradorRemasterizado.IntegradorRemasterizado.repository.IPatientRepository;
import com.IntegradorRemasterizado.IntegradorRemasterizado.service.IDao;
import com.IntegradorRemasterizado.IntegradorRemasterizado.service.IPatientService;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class PatientService /*implements IPatientService*/ {

    @Autowired
    private IPatientRepository patientRepository;

    @Autowired
    private ModelMapper modelMapper;

    public PatientDTO registerPatient(PatientDTO patientDTO) {
        //1. Lo tengo que pasar de DTO a entidad.
        Patient patient = mapEntity(patientDTO);

        //2. Lo guardo en la bd.
        Patient patientSave = patientRepository.save(patient);

        //3. Lo vuelvo a convertir a DTO y la retorno
        return mapDTO(patientSave);
    }

    public PatientDTO findById(@NotNull Integer id) {
        Patient patient = patientRepository.getById(id);
        PatientDTO pDTO = mapDTO(patient);
        return pDTO;
    }

    /*public Patient findByEmail(String email){
        return patientIDao.finByEmail(email);
    }*/

    public List<PatientDTO> findAll() {
        //1. Creo una lista de todos los pacientes que hay
        List<Patient> patientsList = patientRepository.findAll();

        //2. Los paso a DTO para retornarlos
        List<PatientDTO> patientsDTOList = patientsList.stream().map(p -> mapDTO(p)).collect(Collectors.toList());
        return patientsDTOList;
    }

    public void delete(@NotNull Integer id) {
        // 1. Buscar la entidad
        Patient patient = patientRepository.getById(id);
        // 2. Verficar que se encontro
        // 3. Elimino el ojeto paciente entero
        patientRepository.delete(patient);
    }

    public PatientDTO update(PatientDTO patientDTO) {
        //1. Casteo el pacienteDTO a paciente
        Patient patient = mapEntity(patientDTO);

        //2. Lo guardo al nuevo paciente
        Patient newPatient = patientRepository.save(patient);

        //3. Lo casteo a DTO y lo retorno
        return mapDTO(newPatient);
    }

    //------ MAPPER----
    private PatientDTO mapDTO(Patient patient){
        PatientDTO patientDTO = modelMapper.map(patient, PatientDTO.class); //Recibo un paciente y lo paso a DTO
        return patientDTO;
    }

    private Patient mapEntity(PatientDTO patientDTO){
        Patient patient = modelMapper.map(patientDTO, Patient.class); //Recibo un DTO y lo paso a paciente
        return patient;
    }
}
