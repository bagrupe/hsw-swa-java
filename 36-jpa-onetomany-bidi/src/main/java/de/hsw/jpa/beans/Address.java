package de.hsw.jpa.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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

    @OneToMany(mappedBy= "address")
    private List<CustomerAddress> customers = new ArrayList<>();


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
        return "Address [customers=" + customers + ", id=" + id + ", street=" + street + ", version=" + version
                + ", zipCity=" + zipCity + "]";
    }

    public List<CustomerAddress> getCustomers() {
        return customers;
    }

    public void setCustomers(List<CustomerAddress> customers) {
        this.customers = customers;
    }

}
