package com.IntegradorRemasterizado.IntegradorRemasterizado.service.impl;

import com.IntegradorRemasterizado.IntegradorRemasterizado.DTO.AppointmentDTO;
import com.IntegradorRemasterizado.IntegradorRemasterizado.DTO.DentistDTO;
import com.IntegradorRemasterizado.IntegradorRemasterizado.model.Appointment;
import com.IntegradorRemasterizado.IntegradorRemasterizado.model.Dentist;
import com.IntegradorRemasterizado.IntegradorRemasterizado.repository.IAppointmentRepository;
import com.IntegradorRemasterizado.IntegradorRemasterizado.service.IAppointmentService;
import com.IntegradorRemasterizado.IntegradorRemasterizado.service.IDao;
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
public class AppointmentService {

    @Autowired
    private IAppointmentRepository appointmentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public AppointmentDTO registerAppointment(AppointmentDTO appointmentDTO){
        Appointment appointment = mapEntity(appointmentDTO);

        Appointment appointmentSave = appointmentRepository.save(appointment);

        return mapDTO(appointmentSave);
    }

    public AppointmentDTO findById(@NotNull Integer id){
        Appointment appointment = appointmentRepository.getById(id);
        AppointmentDTO aDTO = mapDTO(appointment);
        return aDTO;
    }

    public List<AppointmentDTO> findAll(){
        List<Appointment> appointmentList = appointmentRepository.findAll();

        List<AppointmentDTO> appointmentsDTOList = appointmentList.stream().map(a -> mapDTO(a)).collect(Collectors.toList());

        return appointmentsDTOList;

    }

    public void delete(@NotNull Integer id){
        Appointment appointment = appointmentRepository.getById(id);

        appointmentRepository.delete(appointment);

    }

    public AppointmentDTO update(AppointmentDTO appointmentDTO){
        Appointment appointment = mapEntity(appointmentDTO);

        Appointment newAppointment = appointmentRepository.save(appointment);

        return mapDTO(newAppointment);

    }



    //------ MAPPER----
    private AppointmentDTO mapDTO(Appointment appointment){
        AppointmentDTO appointmentDTO = modelMapper.map(appointment, AppointmentDTO.class); //Recibo un turno y lo paso a DTO
        return appointmentDTO;
    }

    private Appointment mapEntity(AppointmentDTO appointmentDTO){
        Appointment appointment = modelMapper.map(appointmentDTO, Appointment.class); //Recibo un DTO y lo paso a turno
        return appointment;
    }
}
