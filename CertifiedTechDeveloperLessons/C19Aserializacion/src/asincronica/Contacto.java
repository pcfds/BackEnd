package asincronica;

import java.io.Serializable;

public class Contacto implements Serializable {
    private String name;
    private String email;
    private int telefono;

    public Contacto(String name, String email, int telefono) {
        this.name = name;
        this.email = email;
        this.telefono = telefono;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
