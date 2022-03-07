package Practica;

import java.time.LocalDate;

public class Persona {

        private String nombre;
        private String apellido;
        private String email;
        private LocalDate edad;

        public Persona(String nombre, String apellido, String email, LocalDate edad) {
            this.nombre = nombre;
            this.apellido = apellido;
            this.email = email;
            this.edad = edad;
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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public LocalDate getEdad() {
            return edad;
        }

        public void setEdad(LocalDate edad) {
            this.edad = edad;
        }

        public String nombreYApellido(){
            return nombre + " " + apellido;
        }

        public boolean esMayor(){
            return LocalDate.now().compareTo(edad.plusYears(18)) > 0;
        }

    }
