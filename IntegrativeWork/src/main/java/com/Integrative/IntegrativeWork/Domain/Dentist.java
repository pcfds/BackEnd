package com.Integrative.IntegrativeWork.Domain;

public class Dentist {
    private int id_dentist;
    private String name;
    private String surname;
    private int register;

    public Dentist(int id_dentist, String name, String surname, int register) {
        this.id_dentist = id_dentist;
        this.name = name;
        this.surname = surname;
        this.register = register;
    }

    public Dentist(String name, String surname, int register) {
        this.name = name;
        this.surname = surname;
        this.register = register;
    }

    public int getId_dentist() {
        return id_dentist;
    }

    public void setId_dentist(int id_dentist) {
        this.id_dentist = id_dentist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getRegister() {
        return register;
    }

    public void setRegister(int register) {
        this.register = register;
    }

    @Override
    public String toString() {
        return "Dentist{" +
                "id=" + id_dentist +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", register=" + register +
                '}';
    }
}
