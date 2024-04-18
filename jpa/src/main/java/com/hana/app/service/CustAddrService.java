package com.hana.app.service;

import com.hana.app.data.entity.CustAddrEntity;
import com.hana.app.frame.HanaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustAddrService implements HanaService<CustAddrEntity, Long> {
    @Override
    public CustAddrEntity insert(CustAddrEntity custAddrEntity) {
        return null;
    }

    @Override
    public Boolean delete(Long aLong) {
        return null;
    }

    @Override
    public CustAddrEntity update(CustAddrEntity custAddrEntity) {
        return null;
    }

    @Override
    public Optional<CustAddrEntity> get(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<CustAddrEntity> get() {
        return List.of();
    }
}
