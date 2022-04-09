package com.IntegradorRemasterizado.IntegradorRemasterizado.repository;

import com.IntegradorRemasterizado.IntegradorRemasterizado.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<Patient, Integer> {

}
