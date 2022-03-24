package com.Integrative.IntegrativeWork.Domain;

public class Dentist {
    private int dentist_id;
    private String name;
    private String surname;
    private int register;

    public Dentist(int dentist_id, String name, String surname, int register) {
        this.dentist_id = dentist_id;
        this.name = name;
        this.surname = surname;
        this.register = register;
    }

    public Dentist(String name, String surname, int register) {
        this.name = name;
        this.surname = surname;
        this.register = register;
    }

    public int getDentist_id() {
        return dentist_id;
    }

    public void setDentist_id(int dentist_id) {
        this.dentist_id = dentist_id;
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
                "id=" + dentist_id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", register=" + register +
                '}';
    }
}
