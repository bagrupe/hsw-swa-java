package de.hsw.shop.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.hsw.shop.beans.Order;
import de.hsw.shop.repositories.OrderRepository;

@Service
public class OrderService {
    private OrderRepository repository;

    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Order save(Order c) {
        return repository.save(c);
    }

    public void saveAll(List<Order> orders) {
        repository.saveAll(orders);
    }

    public Optional<Order> findById(long id) {
        return repository.findById(id);
    }

    public List<Order> findAll() {
        Iterable<Order> it = repository.findAll();
        
        List<Order> orders = new ArrayList<>();

        it.forEach(obj -> orders.add(obj));

        return orders;
    }

    public List<Order> findAllById(List<Long> ids) {
        Iterable<Order> it = repository.findAllById(ids);
        
        List<Order> orders = new ArrayList<>();

        it.forEach(obj -> orders.add(obj));

        return orders;
    }

    public void delete(Order c) {
        repository.delete(c);
    }

    public long count() {
        return repository.count();
    }
}
