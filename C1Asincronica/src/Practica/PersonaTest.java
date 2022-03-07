package Practica;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


class PersonaTest {

    Persona persona1 = new Persona("Julian", "Mac Allister", "juli@asd.com", LocalDate.of(2000, 10, 22));

    @Test

    public void validarNombreyApellido() {

        String testNombre = persona1.nombreYApellido();
        Assertions.assertEquals("Julian Mac Allister", testNombre);


    }

    @Test

    public void validarEdad(){

        boolean testEdad = persona1.esMayor();
        Assertions.assertTrue(testEdad);

    }

}