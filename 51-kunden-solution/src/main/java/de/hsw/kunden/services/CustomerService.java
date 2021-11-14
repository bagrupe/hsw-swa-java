package de.hsw.kunden.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.hsw.kunden.beans.Customer;
import de.hsw.kunden.repositories.CustomerRepository;

@Service
public class CustomerService {
    private CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer save(Customer c) {
        return repository.save(c);
    }

    public Optional<Customer> findById(long id) {
        return repository.findById(id);
    }

    public void delete(Customer c) {
        repository.delete(c);
    }
}
