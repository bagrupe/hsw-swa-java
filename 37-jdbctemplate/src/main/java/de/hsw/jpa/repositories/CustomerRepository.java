package de.hsw.jpa.repositories;

import org.springframework.stereotype.Repository;

import de.hsw.jpa.beans.Customer;

@Repository
public interface CustomerRepository {
    public Customer save(Customer a);

    public Customer get(long id);
}
