package ApiRestFinalProject.DentalClinic.Repository;

import ApiRestFinalProject.DentalClinic.Entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppointmentRespository extends JpaRepository<Appointment, Integer> {
}
