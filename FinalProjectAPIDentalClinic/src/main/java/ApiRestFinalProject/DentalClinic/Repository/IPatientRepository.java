package ApiRestFinalProject.DentalClinic.Repository;

import ApiRestFinalProject.DentalClinic.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Integer> {


@Query(value = "SELECT * FROM patient WHERE patient.email = ?1", nativeQuery = true)
Patient findByEmail(String email);


}
