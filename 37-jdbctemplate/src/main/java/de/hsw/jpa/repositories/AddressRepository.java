package de.hsw.jpa.repositories;

import org.springframework.stereotype.Repository;

import de.hsw.jpa.beans.Address;

@Repository
public interface AddressRepository {
    public Address save(Address a);

    public Address get(long id);
}
