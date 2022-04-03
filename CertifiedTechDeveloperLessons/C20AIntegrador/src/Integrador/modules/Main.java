package Integrador.modules;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Empleado e1 = new Empleado("Zoé", "Tira", 00001, 10d);
        Empleado e2 = new Empleado("Pablo", "Cristaldo", 00002, 5d);
        Empleado e3 = new Empleado("Matias", "Raspa", 00003, 8d);
        Empleado e4 = new Empleado("Julian", "McCallister", 00004, 100d);

        Empresa rockyBalboa = new Empresa("Rocky Balboa", 2232323);

        rockyBalboa.listarEmpleados(e1);
        rockyBalboa.listarEmpleados(e2);
        rockyBalboa.listarEmpleados(e3);
        rockyBalboa.listarEmpleados(e4);


        //Guardamos toda la coleccion de paginas en un archivo
        FileOutputStream fo = null;
        try {
            fo = new FileOutputStream("OutputFile.txt");
            ObjectOutputStream dos = new ObjectOutputStream(fo);

            dos.writeObject(rockyBalboa);

        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
        }

        //Recuperamos toda la colección con cada una de las paginas del archivo
        List<Empleado> empleadosRecuperados = null;
        FileInputStream fi = null;
        ArrayList<Empleado> lista = null;
        try {
            fi = new FileInputStream("OutputFile.txt");
            ObjectInputStream ois = new ObjectInputStream(fi);
            Empresa empleados = (Empresa) ois.readObject();
            lista = (ArrayList<Empleado>) empleados.getEmpleados();
            for (Empleado empleado : lista)
                System.out.println("Name:" + empleado.getNombre() + " Surname " + empleado.getApellido() + " Legajo; " + empleado.getLegajo() + " Sueldo " + empleado.getSueldo());


        } catch (Exception e) {
            e.getMessage();
        }

    }
}




