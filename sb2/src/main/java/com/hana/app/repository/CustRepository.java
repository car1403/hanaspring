package com.hana.app.repository;

import com.github.pagehelper.Page;
import com.hana.app.data.dto.CustDto;
import com.hana.app.frame.HanaRepository;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CustRepository extends HanaRepository<String, CustDto> {
    Page<CustDto> getPage();
}
