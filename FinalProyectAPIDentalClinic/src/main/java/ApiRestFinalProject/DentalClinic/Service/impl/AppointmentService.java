package ApiRestFinalProject.DentalClinic.Service.impl;

import ApiRestFinalProject.DentalClinic.DTO.AppointmentDTO;
import ApiRestFinalProject.DentalClinic.Entities.Appointment;
import ApiRestFinalProject.DentalClinic.Repository.IAppointmentRespository;
import ApiRestFinalProject.DentalClinic.Service.IAppointmentService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class AppointmentService implements IAppointmentService {

    @Autowired
    private IAppointmentRespository appointmentRepository;
    @Autowired
    ObjectMapper objectMapper;


    @Override
    public AppointmentDTO findById(Integer id) {

        Optional<Appointment> appointment = appointmentRepository.findById(id);
        AppointmentDTO appointmentDTO = null;
        if(appointment.isPresent())
            appointmentDTO = objectMapper.convertValue(appointment, AppointmentDTO.class);
        return appointmentDTO;
    }

    @Override
    public AppointmentDTO create(AppointmentDTO appointmentDTO) {

        Appointment appointment = objectMapper.convertValue(appointmentDTO, Appointment.class);
        appointmentRepository.save(appointment);
        return appointmentDTO;
    }

    @Override
    public void deleteById(Integer id) {
        appointmentRepository.deleteById(id);

    }

    @Override
    public AppointmentDTO update(AppointmentDTO appointmentDTO) {

        Appointment appointment = objectMapper.convertValue(appointmentDTO, Appointment.class);
        appointmentRepository.save(appointment);
        return appointmentDTO;
    }

    @Override
    public Set<AppointmentDTO> findAll() {
        List<Appointment> appointments = appointmentRepository.findAll();
        Set<AppointmentDTO> appointmentDTOS = new HashSet<>();
        for (Appointment appointment : appointments) {
            appointmentDTOS.add(objectMapper.convertValue(appointment, AppointmentDTO.class));
        }
        return appointmentDTOS;
    }
}
