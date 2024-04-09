package com.hana.app.repository;

import com.hana.app.data.dto.BoardDto;
import com.hana.app.data.dto.CommentDto;
import com.hana.app.frame.HanaRepository;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentRepository extends HanaRepository<Integer, CommentDto> {

}
