package de.hsw.jpa.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.hsw.jpa.beans.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
    
}
