package de.hsw.jpa.beans;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "T_CUSTOMER_ADDRESS")
public class CustomerAddress {
    @EmbeddedId
    private CustomerAddressId id;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "address_id")
    private Address address;

    public CustomerAddressId getId() {
        return id;
    }

    public void setId(CustomerAddressId id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CustomerAddress [address=" + address.getId() + ", customer=" + customer.getId() + ", id=" + id + "]";
    }

}
