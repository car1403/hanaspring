package com.hana.app.service;

import com.hana.app.data.entity.CateEntity;
import com.hana.app.data.entity.CustInfoEntity;
import com.hana.app.frame.HanaService;
import com.hana.app.repository.CateRepository;
import com.hana.app.repository.CustInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustInfoService implements HanaService<CustInfoEntity, Integer> {

    private final CustInfoRepository repository;

    @Override
    public CustInfoEntity insert(CustInfoEntity entity) {
        return repository.save(entity);
    }

    @Override
    public Boolean delete(Integer integer) {
        repository.deleteById(integer);
        return true;
    }

    @Override
    public CustInfoEntity update(CustInfoEntity entity) {
        return repository.save(entity);
    }

    @Override
    public Optional<CustInfoEntity> get(Integer integer) {
        return repository.findById(integer);
    }

    @Override
    public List<CustInfoEntity> get() {
        return repository.findAll();
    }
}
