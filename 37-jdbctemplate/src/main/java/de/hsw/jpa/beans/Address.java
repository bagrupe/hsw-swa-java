package de.hsw.jpa.beans;

public class Address {

    private long id;

    private String street;

    private String zipCity;

    public Address() {
    }

    public Address(long id, String street, String zipCity) {
        this.id = id;
        this.street = street;
        this.zipCity = zipCity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCity() {
        return zipCity;
    }

    public void setZipCity(String zipCity) {
        this.zipCity = zipCity;
    }

    @Override
    public String toString() {
        return "Address [id=" + id + ", street=" + street + ", zipCity=" + zipCity + "]";
    }
}
