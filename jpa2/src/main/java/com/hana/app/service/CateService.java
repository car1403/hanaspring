package com.hana.app.service;

import com.hana.app.data.entity.CateEntity;
import com.hana.app.frame.HanaService;
import com.hana.app.repository.CateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CateService implements HanaService<CateEntity, Integer> {

    private final CateRepository repository;

    @Override
    public CateEntity insert(CateEntity entity) {
        return repository.save(entity);
    }

    @Override
    public Boolean delete(Integer integer) {
        repository.deleteById(integer);
        return true;
    }

    @Override
    public CateEntity update(CateEntity entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<CateEntity> get(Integer integer) {
        return repository.findById(integer);
    }

    @Override
    public List<CateEntity> get() {
        return repository.findAll();
    }
}
