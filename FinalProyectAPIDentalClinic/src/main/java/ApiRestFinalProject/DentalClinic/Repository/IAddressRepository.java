package ApiRestFinalProject.DentalClinic.Repository;

import ApiRestFinalProject.DentalClinic.Entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Integer> {
}
