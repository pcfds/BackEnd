package com.Integrative.IntegrativeWork.Domain;

public class Dentist {
    private Integer id;
    private String name;
    private String surname;
    private Integer register;

    public Dentist(Integer id, String name, String surname, Integer register) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.register = register;
    }

    public Dentist(String name, String surname, Integer register) {
        this.name = name;
        this.surname = surname;
        this.register = register;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getRegister() {
        return register;
    }

    public void setRegister(Integer register) {
        this.register = register;
    }

    @Override
    public String toString() {
        return "Dentist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", register=" + register +
                '}';
    }
}
