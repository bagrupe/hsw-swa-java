package de.hsw.swa1jpa.beans;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "T_CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long customerId;

    @Column(name = "CUSTOMER_NAME")
    private String name;

    @Column
    private LocalDate birthDate;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL) 
    @PrimaryKeyJoinColumn
    private Address address;

    @Version
    private long version;

    public Customer() {
    }

    public Customer(long id, String name, LocalDate birthDate, long version) {
        this.customerId = id;
        this.name = name;
        this.birthDate = birthDate;
        this.version = version;
    }

    public long getId() {
        return customerId;
    }

    public void setId(long id) {
        this.customerId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Customer [address=" + address + ", birthDate=" + birthDate + ", customerId=" + customerId + ", name=" + name
                + ", version=" + version + "]";
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
