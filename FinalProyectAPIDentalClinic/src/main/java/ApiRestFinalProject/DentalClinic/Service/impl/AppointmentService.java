package ApiRestFinalProject.DentalClinic.Service.impl;

import ApiRestFinalProject.DentalClinic.DTO.AppointmentDTO;
import ApiRestFinalProject.DentalClinic.Entities.Appointment;
import ApiRestFinalProject.DentalClinic.Repository.IAppointmentRespository;
import ApiRestFinalProject.DentalClinic.Service.IAppointmentService;
import com.sun.istack.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class AppointmentService implements IAppointmentService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IAppointmentRespository iAppointmentRespository;

    public AppointmentDTO create (AppointmentDTO appointmentDTO){
        Appointment appointment = mapEntity(appointmentDTO);

        Appointment appointmentSave = iAppointmentRespository.save(appointment);

        return mapDTO(appointmentSave);
    }

    public AppointmentDTO findById(@NotNull Integer id){
        Appointment appointment = iAppointmentRespository.getById(id);
        AppointmentDTO aDTO = mapDTO(appointment);
        return aDTO;
    }

    public List<AppointmentDTO> findAll(){
        List<Appointment> appointmentList = iAppointmentRespository.findAll();

        List<AppointmentDTO> appointmentsDTOList = appointmentList.stream().map(a -> mapDTO(a)).collect(Collectors.toList());

        return appointmentsDTOList;

    }

    public void deleteById (@NotNull Integer id){
        Appointment appointment = iAppointmentRespository.getById(id);

        iAppointmentRespository.delete(appointment);

    }

    public AppointmentDTO update(AppointmentDTO appointmentDTO){
        Appointment appointment = mapEntity(appointmentDTO);

        Appointment newAppointment = iAppointmentRespository.save(appointment);

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
