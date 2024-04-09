package com.hana.app.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hana.app.data.dto.CustDto;
import com.hana.app.frame.HanaService;
import com.hana.app.repository.CustRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustService implements HanaService<String, CustDto> {

    final CustRepository custRepository;

    @Override
    public int add(CustDto custDto) throws Exception {
        return custRepository.insert(custDto);
    }

    @Override
    public int del(String s) throws Exception {
        return custRepository.delete(s);
    }

    @Override
    public int modify(CustDto custDto) throws Exception {
        return custRepository.update(custDto);
    }

    @Override
    public CustDto get(String s) throws Exception {
        return custRepository.selectOne(s);
    }

    @Override
    public List<CustDto> get() throws Exception {
        return custRepository.select();
    }

    public Page<CustDto> getPage(int pageNo) throws Exception {
        PageHelper.startPage(pageNo, 5); // 3: 한화면에 출력되는 개수
        return custRepository.getPage();
    }
}
