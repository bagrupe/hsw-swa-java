package de.hsw.jpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.hsw.jpa.beans.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    
}
