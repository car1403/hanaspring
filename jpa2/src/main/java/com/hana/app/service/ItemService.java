package com.hana.app.service;

import com.hana.app.data.entity.CateEntity;
import com.hana.app.data.entity.ItemEntity;
import com.hana.app.frame.HanaService;
import com.hana.app.repository.CateRepository;
import com.hana.app.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService implements HanaService<ItemEntity, Integer> {

    private final ItemRepository repository;

    @Override
    public ItemEntity insert(ItemEntity entity) {
        return repository.save(entity);
    }

    @Override
    public Boolean delete(Integer integer) {
        repository.deleteById(integer);
        return true;
    }

    @Override
    public ItemEntity update(ItemEntity entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<ItemEntity> get(Integer integer) {
        return repository.findById(integer);
    }

    @Override
    public List<ItemEntity> get() {
        return repository.findAll();
    }
}
