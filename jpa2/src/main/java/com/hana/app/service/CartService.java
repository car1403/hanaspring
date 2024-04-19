package com.hana.app.service;

import com.hana.app.data.entity.CartEntity;
import com.hana.app.data.entity.CateEntity;
import com.hana.app.frame.HanaService;
import com.hana.app.repository.CartRepository;
import com.hana.app.repository.CateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService implements HanaService<CartEntity, Integer> {

    private final CartRepository repository;

    @Override
    public CartEntity insert(CartEntity entity) {
        return repository.save(entity);
    }

    @Override
    public Boolean delete(Integer integer) {
        repository.deleteById(integer);
        return true;
    }

    @Override
    public CartEntity update(CartEntity entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<CartEntity> get(Integer integer) {
        return repository.findById(integer);
    }

    @Override
    public List<CartEntity> get() {
        return repository.findAll();
    }
}
