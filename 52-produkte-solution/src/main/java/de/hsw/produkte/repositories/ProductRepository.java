package de.hsw.produkte.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.hsw.produkte.beans.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    
}
