package de.hsw.swa1jpa.beans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "T_CUSTOMER")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "CUSTOMER_NAME")
    private String name;

    @Column
    private LocalDate birthDate;

    @OneToMany(mappedBy = "customer")
    private List<CustomerAddress> addresses = new ArrayList<>();

    @Version
    private long version;

    public Customer() {
    }

    public Customer(long id, String name, LocalDate birthDate, long version) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.version = version;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        return "Customer [addresses=" + addresses + ", birthDate=" + birthDate + ", id=" + id + ", name=" + name
                + ", version=" + version + "]";
    }

    public List<CustomerAddress> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<CustomerAddress> addresses) {
        this.addresses = addresses;
    }

    
}
