package com.hana.board;

import com.hana.app.data.dto.AddrDto;
import com.hana.app.data.dto.BoardDto;
import com.hana.app.service.AddrService;
import com.hana.app.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import java.sql.SQLException;

@SpringBootTest
@Slf4j
class InsertTests {

    @Autowired
    BoardService boardService;
    @Test
    void contextLoads() {
        BoardDto boardDto = BoardDto.builder().custId("id04").boardTitle("제목1").
                boardContent("내용1").build();
        try {
            boardService.add(boardDto);
            log.info("----------OK----------------");
        } catch (Exception e) {
            if(e instanceof SQLException){
                log.info("----------System Trouble EX0001----------------");
            }else if(e instanceof DuplicateKeyException){
                log.info("----------ID Duplicated EX0002----------------");
            }else{
                log.info("----------Sorry EX0003----------------");
            }

        }
    }

}
