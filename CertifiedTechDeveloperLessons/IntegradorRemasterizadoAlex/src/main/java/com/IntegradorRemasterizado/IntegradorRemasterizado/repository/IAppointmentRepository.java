package com.IntegradorRemasterizado.IntegradorRemasterizado.repository;


import com.IntegradorRemasterizado.IntegradorRemasterizado.model.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppointmentRepository extends JpaRepository<Appointment, Integer> {
}
