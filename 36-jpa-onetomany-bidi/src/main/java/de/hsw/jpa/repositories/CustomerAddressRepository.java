package de.hsw.jpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.hsw.jpa.beans.CustomerAddress;
import de.hsw.jpa.beans.CustomerAddressId;

@Repository
public interface CustomerAddressRepository extends CrudRepository<CustomerAddress, CustomerAddressId> {
    
}
