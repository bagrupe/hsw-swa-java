package de.hsw.jpa.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CustomerAddressId implements Serializable {

    @Column(name = "customer_id")
    private long customerId;

    @Column(name = "address_id")
    private long addressId;

    public CustomerAddressId() {
    }

    public CustomerAddressId(long customerId, long addressId) {
        this.customerId = customerId;
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "CustomerAddressId [addressId=" + addressId + ", customerId=" + customerId + "]";
    }
}
