package com.hana.comment;

import com.hana.app.data.dto.BoardDto;
import com.hana.app.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

@SpringBootTest
@Slf4j
class SelectOneTests {

    @Autowired
    BoardService boardService;
    @Test
    void contextLoads() {
        try {
            BoardDto boardDto = null;
            boardDto = boardService.get(3);
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd hhmmss");
            String nowString = boardDto.getBoardRegdate().format(dateTimeFormatter);
            System.out.println(nowString);
            log.info(boardDto.getBoardRegdate().toString());
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
