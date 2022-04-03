package Practica;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Persona persona1 = new Persona("Julian", "Alvarez", "juli@.", LocalDate.of(2010, 1, 22));

        System.out.println(persona1.nombreYApellido());
        System.out.println(persona1.esMayor());

    }
}
