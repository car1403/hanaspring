package com.hana.app.service;

import com.hana.app.data.entity.CateEntity;
import com.hana.app.data.entity.CustEntity;
import com.hana.app.frame.HanaService;
import com.hana.app.repository.CateRepository;
import com.hana.app.repository.CustRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustService implements HanaService<CustEntity, String> {

    private final CustRepository repository;

    @Override
    public CustEntity insert(CustEntity entity) {
        return repository.save(entity);
    }

    @Override
    public Boolean delete(String id) {
        repository.deleteById(id);
        return true;
    }

    @Override
    public CustEntity update(CustEntity entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<CustEntity> get(String id) {
        return repository.findById(id);
    }

    @Override
    public List<CustEntity> get() {
        return repository.findAll();
    }
}
