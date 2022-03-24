package com.preIntegrador.C23integrativePractice;

import com.preIntegrador.C23integrativePractice.Domain.Paciente;
import com.preIntegrador.C23integrativePractice.Services.ServicePaciente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping
public class PacienteController {
    @GetMapping("index")
    public String usuario(Model model){
        ServicePaciente servicepaciente = new ServicePaciente();
        Paciente paciente1 = ServicePaciente.crearPaciente(2, "Pedro",  "Castro", "pedro@cas.a", 123414,1, "Alfaro", 3245, "San isidro", "Buenos Aires");
           model.addAttribute("nombre", paciente1.getNombre() );
           model.addAttribute("apellido", paciente1.getApellido());
           return "index";
    }
}
