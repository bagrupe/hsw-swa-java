package de.hsw.shop.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.hsw.shop.beans.Shop;
import de.hsw.shop.repositories.ShopRepository;

@Service
public class ShopService {
    private ShopRepository repository;

    @Autowired
    public ShopService(ShopRepository repository) {
        this.repository = repository;
    }

    public Shop save(Shop c) {
        return repository.save(c);
    }

    public void saveAll(List<Shop> shops) {
        repository.saveAll(shops);
    }

    public Optional<Shop> findById(long id) {
        return repository.findById(id);
    }

    public List<Shop> findAll() {
        Iterable<Shop> it = repository.findAll();
        
        List<Shop> shops = new ArrayList<>();

        it.forEach(obj -> shops.add(obj));

        return shops;
    }

    public List<Shop> findAllById(List<Long> ids) {
        Iterable<Shop> it = repository.findAllById(ids);
        
        List<Shop> shops = new ArrayList<>();

        it.forEach(obj -> shops.add(obj));

        return shops;
    }

    public void delete(Shop c) {
        repository.delete(c);
    }

    public long count() {
        return repository.count();
    }
}
