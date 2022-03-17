package Parcial;

import Parcial.Models.Odontologo;

public class Main {
    public static void main(String[] args) {
       Odontologo odontologo = new Odontologo(23, "Juan", "Lopez");
       odontologo.setNumeroDeMatricula(255);
        System.out.println(odontologo);
    }
}
