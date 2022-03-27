package com.Integrative.IntegrativeWork.Domain;

public class Address {

    private int id_address;
    private String street;
    private int number;
    private String city;

    public Address(int id_address, String street, int number, String city) {
        this.id_address = id_address;
        this.street = street;
        this.number = number;
        this.city = city;
    }

    public int getId_address() {
        return id_address;
    }

    public void setId_address(int id_address) {
        this.id_address = id_address;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
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
                "id_address=" + id_address +
                ", street='" + street + '\'' +
                ", number=" + number +
                ", city='" + city + '\'' +
                '}';
    }
}
