package ApiRestFinalProject.DentalClinic.Service.impl;

import ApiRestFinalProject.DentalClinic.DTO.DentistDTO;
import ApiRestFinalProject.DentalClinic.Entities.Dentist;
import ApiRestFinalProject.DentalClinic.Repository.IDentistRepository;
import ApiRestFinalProject.DentalClinic.Service.IDentistService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public class DentistService implements IDentistService {

    @Autowired
    private IDentistRepository iDentistRepository;
    @Autowired
    private ModelMapper modelMapper;

    //------ MAPPER----
    private DentistDTO mapDTO(Dentist dentist){
        DentistDTO dentistDTO = modelMapper.map(dentist, DentistDTO.class);
        return dentistDTO;
    }

    private Dentist mapEntity(DentistDTO dentistDTO){
        Dentist newdentist = modelMapper.map(dentistDTO, Dentist.class);
        return newdentist;
    }


    @Override
    public DentistDTO findById(@NotNull Integer id) {
        Optional<Dentist> dentist = iDentistRepository.findById(id);
        DentistDTO dentistDTO = mapDTO(dentist.get());
        return dentistDTO;
    }

    @Override
    public DentistDTO create(DentistDTO dentistDTO) {
        //DTO recibiendo por parametro
        //1- DTO convertir a entidad
        Dentist dentist = mapEntity(dentistDTO);
        //DTO recibiendo por parametro
        //1- DTO convertir a entidad
        Dentist dentist1 = iDentistRepository.save(dentist);
        //3- la entidad guardada en la base de datos la retornamos como DTO
        return mapDTO(dentist1);


    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public DentistDTO update(DentistDTO dentistDTO) {
        return null;
    }

    @Override
    public List<DentistDTO> findAll() {
        return null;
    }
}
