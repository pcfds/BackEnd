package clinica.dh.repositorio;
import clinica.dh.entidades.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOdontologoRepositorio extends JpaRepository<Odontologo, Integer> {


}
