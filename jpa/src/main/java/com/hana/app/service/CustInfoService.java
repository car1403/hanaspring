package com.hana.app.service;

import com.hana.app.data.entity.CustInfoEntity;
import com.hana.app.frame.HanaService;
import com.hana.app.repository.CustInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CustInfoService implements HanaService<CustInfoEntity, Long> {

    private final CustInfoRepository custInfoRepository;

    @Override
    public CustInfoEntity insert(CustInfoEntity custInfoEntity) {
        return custInfoRepository.save(custInfoEntity);
    }

    @Override
    public Boolean delete(Long aLong) {
        custInfoRepository.deleteById(aLong);
        return true;
    }

    @Override
    public CustInfoEntity update(CustInfoEntity custInfoEntity) {
        return custInfoRepository.save(custInfoEntity);
    }

    @Override
    public Optional<CustInfoEntity> get(Long aLong) {
        return custInfoRepository.findById(aLong);
    }

    @Override
    public List<CustInfoEntity> get() {
        return custInfoRepository.findAll();
    }
}
