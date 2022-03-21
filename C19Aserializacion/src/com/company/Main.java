package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
	    List<Perro> perros = new ArrayList<>();

	    Perro perro1 = new Perro();
	    perro1.setNombre("Cocky");
	    perro1.setEdad(3);

        Perro perro2 = new Perro();
        perro2.setNombre("Pim");
        perro2.setEdad(1);

	    perros.add(perro1);
        perros.add(perro2);

        //Guardamos toda la coleccion de paginas en un archivo
        FileOutputStream fo = null;
        try {
            fo = new FileOutputStream("OutputFile.txt");
            ObjectOutputStream dos = new ObjectOutputStream(fo);

            dos.writeObject(perros);

        } catch (FileNotFoundException e) {
            System.out.println("ERROR:" + e.getMessage());
        }catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
        }

        //Recuperamos toda la colección con cada una de las paginas del archivo
        List<Perro> perros2 = null;
        FileInputStream fi = null;
        try {
            fi = new FileInputStream("OutputFile.txt");
            ObjectInputStream ois = new ObjectInputStream(fi);

            perros2 = (ArrayList) ois.readObject();

        } catch (FileNotFoundException e) {
            System.out.println("ERROR:" + e.getMessage());
        }catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
        }
        for(Perro perro : perros2)
            System.out.println(perro.getNombre() + ": " + perro.getEdad());




    }
}
