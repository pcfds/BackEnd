package ApiRestFinalProject.DentalClinic.Service.impl;

import ApiRestFinalProject.DentalClinic.DTO.DentistDTO;
import ApiRestFinalProject.DentalClinic.Entities.Dentist;
import ApiRestFinalProject.DentalClinic.Repository.IDentistRepository;
import ApiRestFinalProject.DentalClinic.Service.IDentistService;
import com.sun.istack.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

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

    public DentistDTO create (DentistDTO dentistDTO) {
        //1. Lo tengo que pasar de DTO a entidad.
        Dentist dentist = mapEntity(dentistDTO);

        //2. Lo guardo en la bd.
        Dentist dentistSave = iDentistRepository.save(dentist);

        //3. Lo vuelvo a convertir a DTO y la retorno
        return mapDTO(dentistSave);

    }

    // @Override
    public DentistDTO findById(@com.sun.istack.NotNull Integer id) {
        Dentist dentist = iDentistRepository.getById(id);
        DentistDTO dDTO = mapDTO(dentist);
        return dDTO;

    }

   /* public Dentist findByEmail(String email) {
        return dentistRepository.finByEmail(email);
    }*/

    public List<DentistDTO> findAll() {
        //1. Creo una lista de todos los pacientes que hay
        List<Dentist> dentistsList = iDentistRepository.findAll();

        //2. Los paso a DTO para retornarlos
        List<DentistDTO> dentistDTOList = dentistsList.stream().map(d -> mapDTO(d)).collect(Collectors.toList());
        return dentistDTOList;
        //  return dentistRepository.findAll();
    }

    public void deleteById(@NotNull Integer id) {
        // 1. Buscar la entidad
        Dentist dentist = iDentistRepository.getById(id);
        // 2. Verficar que se encontro
        // 3. Eliminarla
        iDentistRepository.delete(dentist);
        // dentistRepository.delete(id);
    }

    public DentistDTO update(DentistDTO dentistDTO) {
        //1. Casteo el dentistaDTO a dentista
        Dentist dentist = mapEntity(dentistDTO);

        //2. Lo guardo al nuevo dentista
        Dentist newDentist = iDentistRepository.save(dentist);

        //3. Lo casteo a DTO y lo retorno
        return mapDTO(newDentist);
    }
}
