package fr.epsi.b3.c1.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse {

    private Integer number;

    private String street;

    private String zipcode;

    private String city;

    public Adresse() {
    }

    public Adresse(Integer number, String street, String zipcode, String city) {
        this.number = number;
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
