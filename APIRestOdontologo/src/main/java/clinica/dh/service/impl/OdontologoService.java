package clinica.dh.service.impl;
import clinica.dh.dto.OdontologoDTO;
import clinica.dh.entidades.Odontologo;
import clinica.dh.repositorio.IOdontologoRepositorio;
import clinica.dh.service.IOdontologoService;
import com.sun.istack.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OdontologoService implements IOdontologoService {

    @Autowired
    private IOdontologoRepositorio odontologoRepositorio;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OdontologoDTO findById(@NotNull Integer id) {
        Odontologo odontologo = odontologoRepositorio.getById(id);
        OdontologoDTO newOdontologoDTO = mapDTO(odontologo);
        return newOdontologoDTO;
        //return mapDTO(odontologo);
    }


    //No lleva id, spring lo crea automaticamente
    @Override
    public OdontologoDTO create(@NotNull OdontologoDTO odontologoDTO) {
        //DTO recibiendo por parametro
        //1- DTO convertir a entidad
        Odontologo odontologo = mapEntity(odontologoDTO);
        //2- la entidad guardamos en la base de datos
        Odontologo newOdontologoSave = odontologoRepositorio.save(odontologo);
        //3- la entidad guardada en la base de datos la retornamos como DTO
        return mapDTO(newOdontologoSave);
    }

    @Override
    public void deleteById(@NotNull Integer id) {
        //1- buscar la entidad 2- verficar que se encontro 3- eliminarla
        Odontologo odontologo = odontologoRepositorio.getById(id);
        odontologoRepositorio.delete(odontologo);
    }

    //Mandamos id
    //Si el id existe el metodo save lo actualiza
    @Override
    public OdontologoDTO update(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapEntity(odontologoDTO);
        Odontologo newOdontologoSave = odontologoRepositorio.save(odontologo);
        return mapDTO(newOdontologoSave);
    }

    @Override
    public List<OdontologoDTO> findAll() {
        List<Odontologo> odontologoList = odontologoRepositorio.findAll();
        List<OdontologoDTO> odontologoDTOList = odontologoList.stream().map(odontologo -> mapDTO(odontologo)).collect(Collectors.toList());
        return odontologoDTOList;
    }

    @Override
    public OdontologoDTO getOdontologoByName(String name) {
        Odontologo odontologo=odontologoRepositorio.findOdontologoByNombre(name);
        return mapDTO(odontologo);
    }

    //------ MAPPER----
    private OdontologoDTO mapDTO(Odontologo odontologo){
        OdontologoDTO odontologoDTO = modelMapper.map(odontologo, OdontologoDTO.class);
        return odontologoDTO;
    }

    private Odontologo mapEntity(OdontologoDTO odontologoDTO){
        Odontologo odontologo = modelMapper.map(odontologoDTO, Odontologo.class);
        return odontologo;
    }


}
