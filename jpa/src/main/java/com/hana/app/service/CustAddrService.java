package com.hana.app.service;

import com.hana.app.data.entity.CustAddrEntity;
import com.hana.app.frame.HanaService;
import com.hana.app.repository.CustAddrRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustAddrService implements HanaService<CustAddrEntity, Long> {

    private final CustAddrRepository custAddrRepository;
    @Override
    public CustAddrEntity insert(CustAddrEntity custAddrEntity) {
        return custAddrRepository.save(custAddrEntity);
    }

    @Override
    public Boolean delete(Long aLong) {
        custAddrRepository.deleteById(aLong);
        return true;
    }

    @Override
    public CustAddrEntity update(CustAddrEntity custAddrEntity) {
        return custAddrRepository.save(custAddrEntity);
    }

    @Override
    public Optional<CustAddrEntity> get(Long aLong) {
        return custAddrRepository.findById(aLong);
    }

    @Override
    public List<CustAddrEntity> get() {
        return custAddrRepository.findAll();
    }
}
