package asincronica;

import com.company.Perro;

import javax.management.modelmbean.InvalidTargetObjectTypeException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Contacto> contactos = new ArrayList<>();

        Contacto c1 = new Contacto("Tomas", "tomas@dh.com", 123456);
        Contacto c2 = new Contacto("Manuel", "m@m.com", 123545);
        contactos.add(c1);
        contactos.add(c2);
        //Guardamos toda la coleccion de paginas en un archivo
        FileOutputStream fo = null;

        try {
            fo = new FileOutputStream("OutputFileContacto.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fo);
            oos.writeObject(contactos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Recuperamos toda la colección con cada una de las paginas del archivo

        List<Contacto> contactosRecuperados = null;
        FileInputStream fi = null;

        try {
            fi = new FileInputStream("OutputFile.txt");
            ObjectInputStream ois = new ObjectInputStream(fi);
            contactosRecuperados = (ArrayList) ois.readObject();
        } catch (Exception e) {
            e.getMessage();
        } for (Contacto contacto : contactosRecuperados)
            System.out.println("Name:" + contacto.getName() + " Mail " + contacto.getEmail() + " Telefono; " + contacto.getTelefono());

    }
}
