package de.hsw.kunden.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.hsw.kunden.beans.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    
}
