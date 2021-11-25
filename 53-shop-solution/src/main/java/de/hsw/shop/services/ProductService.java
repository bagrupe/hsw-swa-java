package de.hsw.shop.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.hsw.shop.beans.Product;
import de.hsw.shop.repositories.ProductRepository;

@Service
public class ProductService {
    private ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product save(Product c) {
        return repository.save(c);
    }

    public void saveAll(List<Product> products) {
        repository.saveAll(products);
    }

    public Optional<Product> findById(long id) {
        return repository.findById(id);
    }

    public List<Product> findAll() {
        Iterable<Product> it = repository.findAll();
        
        List<Product> products = new ArrayList<>();

        it.forEach(obj -> products.add(obj));

        return products;
    }

    public List<Product> findAllById(List<Long> ids) {
        Iterable<Product> it = repository.findAllById(ids);
        
        List<Product> products = new ArrayList<>();

        it.forEach(obj -> products.add(obj));

        return products;
    }

    public void delete(Product c) {
        repository.delete(c);
    }

    public long count() {
        return repository.count();
    }
}
