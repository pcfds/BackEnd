package com.IntegradorRemasterizado.IntegradorRemasterizado.service.impl;

import com.IntegradorRemasterizado.IntegradorRemasterizado.DTO.DentistDTO;
import com.IntegradorRemasterizado.IntegradorRemasterizado.model.Dentist;
import com.IntegradorRemasterizado.IntegradorRemasterizado.repository.IDentistRepository;
import com.IntegradorRemasterizado.IntegradorRemasterizado.service.IDentistService;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class DentistService /*implements IDentistService*/ { //poruqe me tira error?

    @Autowired
    private IDentistRepository dentistRepository;

    @Autowired
    private ModelMapper modelMapper;

   // @Autowired
 //  private ObjectMapper modelMapper; // Esto es lo mismo que model mapper pero sin la dependencia. Es el qeu trae por defecto Maven

    public DentistDTO registerDentist(DentistDTO dentistDTO) {
        //1. Lo tengo que pasar de DTO a entidad.
        Dentist dentist = mapEntity(dentistDTO);

        //2. Lo guardo en la bd.
        Dentist dentistSave = dentistRepository.save(dentist);

        //3. Lo vuelvo a convertir a DTO y la retorno
        return mapDTO(dentistSave);

    }

   // @Override
    public DentistDTO findById(@NotNull Integer id) {
        Dentist dentist = dentistRepository.getById(id);
        DentistDTO dDTO = mapDTO(dentist);
        return dDTO;

    }

   /* public Dentist findByEmail(String email) {
        return dentistRepository.finByEmail(email);
    }*/

    public List<DentistDTO> findAll() {
        //1. Creo una lista de todos los pacientes que hay
        List<Dentist> dentistsList = dentistRepository.findAll();

        //2. Los paso a DTO para retornarlos
        List<DentistDTO> dentistDTOList = dentistsList.stream().map(d -> mapDTO(d)).collect(Collectors.toList());
        return dentistDTOList;
      //  return dentistRepository.findAll();
    }

    public void deleteById(@NotNull Integer id) {
        // 1. Buscar la entidad
        Dentist dentist = dentistRepository.getById(id);
        // 2. Verficar que se encontro
        // 3. Eliminarla
        dentistRepository.delete(dentist);
       // dentistRepository.delete(id);
    }

     public DentistDTO update(DentistDTO dentistDTO) {
        //1. Casteo el dentistaDTO a dentista
        Dentist dentist = mapEntity(dentistDTO);

        //2. Lo guardo al nuevo dentista
        Dentist newDentist = dentistRepository.save(dentist);

        //3. Lo casteo a DTO y lo retorno
        return mapDTO(newDentist);
    }

    //------ MAPPER----
    private DentistDTO mapDTO(Dentist dentist){
        DentistDTO dentistDTO = modelMapper.map(dentist, DentistDTO.class); //Recibo un dentista y lo paso a DTO
        return dentistDTO;
    }

    private Dentist mapEntity(DentistDTO dentistDTO){
        Dentist dentist = modelMapper.map(dentistDTO, Dentist.class); //Recibo un DTO y lo paso a dentista
        return dentist;
    }


}