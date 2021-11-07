package de.hsw.jpa.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "T_ADDRESS")
public class Address {
    @Id
    private long customerId;

    @Column
    private String street;

    @Column
    private String zipCity;

    @Version
    private long version;

    @OneToOne 
    @MapsId 
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
        return customerId;
    }

    public void setId(long id) {
        this.customerId = id;
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
        return "Address [customerId=" + customerId + ", street=" + street + ", version="
                + version + ", zipCity=" + zipCity + "]";
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
