package de.hsw.shop.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.hsw.shop.beans.Employee;
import de.hsw.shop.repositories.EmployeeRepository;

@Service
public class EmployeeService {
    private EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee save(Employee c) {
        return repository.save(c);
    }

    public void saveAll(List<Employee> employees) {
        repository.saveAll(employees);
    }

    public Optional<Employee> findById(long id) {
        return repository.findById(id);
    }

    public List<Employee> findAll() {
        Iterable<Employee> it = repository.findAll();
        
        List<Employee> employees = new ArrayList<>();

        it.forEach(obj -> employees.add(obj));

        return employees;
    }

    public List<Employee> findAllById(List<Long> ids) {
        Iterable<Employee> it = repository.findAllById(ids);
        
        List<Employee> employees = new ArrayList<>();

        it.forEach(obj -> employees.add(obj));

        return employees;
    }

    public void delete(Employee c) {
        repository.delete(c);
    }

    public long count() {
        return repository.count();
    }

    public boolean isAuthorized(long id, String password) {
        Optional<Employee> Employee = findById(id);

        // Normalerweise wäre das Passwort hier gesalzen und SHA-256 gehasht und wir würden einen Web Token generieren
        if(Employee.isPresent() && Employee.get().getPassword().equals(password)) {
            return true;
        }

        return false;
    }
}
