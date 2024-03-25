package com.hana.app.service;

import com.hana.app.data.CustDto;
import com.hana.app.exception.DuplicatedIdException;
import com.hana.app.frame.Dao;
import com.hana.app.frame.Service;
import com.hana.app.repository.CustDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
@org.springframework.stereotype.Service
public class CustService implements Service<String, CustDto> {
    @Autowired
    Dao<String, CustDto> dao;

    @Override
    public int add(CustDto custDto) throws DuplicatedIdException {
        System.out.println("Start TR....");
        try {
            dao.insert(custDto);
            System.out.println("COMMIT....");
        }catch(DuplicatedIdException e){
            System.out.println("ROLLBACK....");
            throw e;
        }finally {
            System.out.println("End TR....");
        }

        // SMS ..
        System.out.println("Send SMS ....");
        return 0;
    }

    @Override
    public int del(String s) throws Exception {

        dao.delete(s);
        return 0;
    }

    @Override
    public int modify(CustDto custDto) throws Exception {

        dao.update(custDto);
        return 0;
    }

    @Override
    public CustDto get(String s) throws Exception {
        return dao.select(s);
    }

    @Override
    public List<CustDto> get() throws Exception {
        return dao.select();
    }


}
