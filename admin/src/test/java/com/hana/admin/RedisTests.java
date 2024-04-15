package com.hana.admin;

import com.hana.app.data.entity.LoginCust;
import com.hana.app.repository.LoginCustRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class RedisTests {
    @Autowired
    LoginCustRepository loginCustRepository;
    @Test
    void contextLoads() {
        long cnt = loginCustRepository.count();
        log.info("Count------------------------"+cnt);

        Iterable<LoginCust> list =  loginCustRepository.findAll();
        list.forEach(c->{log.info(c.toString());});
    }

}
