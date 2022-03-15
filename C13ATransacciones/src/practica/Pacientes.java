package practica;

import java.time.LocalDate;

public class Pacientes {

    private int id;
    private String nombre;
    private String apellido;
    private String domicilio;
    private int dni;
    private int fechDeAlta;
    private String usuario;
    private String contrasenia;

    public Pacientes(int id, String nombre, String apellido, String domicilio, int dni, int fechDeAlta, String usuario, String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.dni = dni;
        this.fechDeAlta = fechDeAlta;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getFechDeAlta() {
        return fechDeAlta;
    }

    public void setFechDeAlta(int fechDeAlta) {
        this.fechDeAlta = fechDeAlta;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String cambiarContrasenia(String contrasenia){
        return  this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "Pacientes{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", dni=" + dni +
                ", fechDeAlta=" + fechDeAlta +
                ", usuario='" + usuario + '\'' +
                ", contraseña='" + contrasenia + '\'' +
                '}';
    }
}
