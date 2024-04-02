package com.hana.item;

import com.hana.app.data.dto.ItemDto;
import com.hana.app.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

import java.sql.SQLException;

@SpringBootTest
@Slf4j
class UpdateTests {

    @Autowired
    ItemService insertService;
    @Test
    void contextLoads() {
        ItemDto itemDto = ItemDto.builder().itemId(1).itemName("xxxx").itemPrice(30000L).imgName("b.jpg").build();
        try {
            insertService.modify(itemDto);
            log.info("----------OK----------------");
        } catch (Exception e) {
            if(e instanceof SQLException){
                log.info("----------System Trouble EX0001----------------");
            }else if(e instanceof DuplicateKeyException){
                log.info("----------ID Duplicated EX0002----------------");
            }else{
                e.printStackTrace();
                log.info("----------Sorry EX0003----------------");
            }

        }
    }

}
