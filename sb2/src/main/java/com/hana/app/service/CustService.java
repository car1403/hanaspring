package com.hana.app.service;

import com.hana.app.data.dto.CustDto;
import com.hana.app.frame.HanaService;
import com.hana.app.repository.CustRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustService implements HanaService<String, CustDto> {

    @Autowired
    CustRepository custRepository;

    @Override
    public int add(CustDto custDto) throws Exception {
        return custRepository.insert(custDto);
    }

    @Override
    public int del(String s) throws Exception {
        return 0;
    }

    @Override
    public int modify(CustDto custDto) throws Exception {
        return 0;
    }

    @Override
    public CustDto get(String s) throws Exception {
        return null;
    }

    @Override
    public List<CustDto> get() throws Exception {
        return null;
    }
}
