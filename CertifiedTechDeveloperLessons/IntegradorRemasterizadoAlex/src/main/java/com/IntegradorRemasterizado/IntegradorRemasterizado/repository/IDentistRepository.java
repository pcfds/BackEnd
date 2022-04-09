package com.IntegradorRemasterizado.IntegradorRemasterizado.repository;

import com.IntegradorRemasterizado.IntegradorRemasterizado.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDentistRepository extends JpaRepository<Dentist, Integer> {
//Aca le agrego los metodos por los que quiero buscar, eliminar etc y que no estan en el CRUD de JPA

}
