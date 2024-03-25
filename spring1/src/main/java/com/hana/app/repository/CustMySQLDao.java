package com.hana.app.repository;

import com.hana.app.data.CustDto;
import com.hana.app.exception.DuplicatedIdException;
import com.hana.app.frame.Dao;

import java.util.List;

public class CustMySQLDao implements Dao<String, CustDto> {
    /**
     * 2024.3.13
     * JMLEE
     *
     * @param custDto : CustDto
     * @return int
     */
    @Override
    public int insert(CustDto custDto) throws DuplicatedIdException {
        System.out.println("Inserted MySQL Database...."+custDto);
        return 0;
    }

    @Override
    public int delete(String s) throws Exception {
        return 0;
    }

    @Override
    public int update(CustDto custDto) throws Exception {
        return 0;
    }

    @Override
    public CustDto select(String s) throws Exception {
        return null;
    }

    @Override
    public List<CustDto> select() throws Exception {
        return null;
    }
}
