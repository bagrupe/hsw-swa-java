package de.hsw.jpa.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "T_ADDRESS")
public class Address {
    @Id
    private long id;

    @Column
    private String street;

    @Column
    private String zipCity;

    @Version
    private long version;

    @ManyToOne 
    @JoinColumn(name = "customer_id") 
    private Customer customer;

    public Address() {
    }

    public Address(String street, String zipCity, long version) {
        this.street = street;
        this.zipCity = zipCity;
        this.version = version;
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

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Address [id=" + id + ", street=" + street + ", version="
                + version + ", zipCity=" + zipCity + "]";
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
