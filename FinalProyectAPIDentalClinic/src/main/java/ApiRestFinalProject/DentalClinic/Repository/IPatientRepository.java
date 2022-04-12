package ApiRestFinalProject.DentalClinic.Repository;

import ApiRestFinalProject.DentalClinic.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IPatientRepository extends JpaRepository<Patient, Integer> {

// Buscar  por email dentist
//@Query("SELECT p FROM Patient WHERE p.email = ?1")
//Optional<Patient> findByEmail(String email);
}
