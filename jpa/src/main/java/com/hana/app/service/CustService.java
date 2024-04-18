package com.hana.app.service;

import com.hana.app.data.entity.CustEntity;
import com.hana.app.frame.HanaService;
import com.hana.app.repository.CustRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustService implements HanaService<CustEntity,String> {

    private final CustRepository custRepository;

    @Override
    public CustEntity insert(CustEntity custEntity) {
        return custRepository.save(custEntity);
    }

    @Override
    public Optional<CustEntity> get(String s) {
        return custRepository.findById(s);
    }

    @Override
    public List<CustEntity> get() {
        return custRepository.findAll();
    }

    @Override
    public Boolean delete(String s) {
        custRepository.deleteById(s);
        return true;
    }

    @Override
    public CustEntity update(CustEntity custEntity) {
        return custRepository.save(custEntity);
    }
}
