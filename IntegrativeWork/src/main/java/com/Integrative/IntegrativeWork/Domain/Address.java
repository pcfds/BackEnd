package com.Integrative.IntegrativeWork.Domain;

public class Address {

    private Integer id;
    private String street;
    private Integer number;
    private String city;

    public Address(Integer id, String street, Integer number, String city) {
        this.id = id;
        this.street = street;
        this.number = number;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id_address=" + id +
                ", street='" + street + '\'' +
                ", number=" + number +
                ", city='" + city + '\'' +
                '}';
    }
}
