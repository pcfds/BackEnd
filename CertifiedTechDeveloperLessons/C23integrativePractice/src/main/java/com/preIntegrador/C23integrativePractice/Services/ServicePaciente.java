package com.preIntegrador.C23integrativePractice.Services;

import com.preIntegrador.C23integrativePractice.Domain.Domicilio;
import com.preIntegrador.C23integrativePractice.Domain.Paciente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServicePaciente {
       private static List<Paciente> pacienteList = new ArrayList<Paciente>();

    public static Paciente crearPaciente(long paciente_id, String nombre, String apellido, String email, int dni, long domicilio_id, String direccion, int numero, String localidad, String provincia) {
        Domicilio domicilio = new Domicilio(domicilio_id, direccion, numero, localidad, provincia);
        Paciente paciente = new Paciente(paciente_id, nombre, apellido, email, dni, new Date(), domicilio);
        pacienteList.add(paciente);


        return paciente;
    }

    public List<Paciente> getPacienteList() {
        return pacienteList;
    }

    public void setPacienteList(List<Paciente> pacienteList) {
        this.pacienteList = pacienteList;
    }
}
