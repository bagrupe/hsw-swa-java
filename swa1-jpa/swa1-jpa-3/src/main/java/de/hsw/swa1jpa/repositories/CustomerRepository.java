package de.hsw.swa1jpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.hsw.swa1jpa.beans.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    
}
