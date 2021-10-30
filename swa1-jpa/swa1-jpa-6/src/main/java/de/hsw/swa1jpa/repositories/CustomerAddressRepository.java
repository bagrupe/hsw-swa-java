package de.hsw.swa1jpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.hsw.swa1jpa.beans.CustomerAddress;
import de.hsw.swa1jpa.beans.CustomerAddressId;

@Repository
public interface CustomerAddressRepository extends CrudRepository<CustomerAddress, CustomerAddressId> {
    
}
