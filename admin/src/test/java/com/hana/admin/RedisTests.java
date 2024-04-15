package com.hana.admin;

import com.hana.app.data.entity.LoginCust;
import com.hana.app.repository.LoginCustRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
class RedisTests {
    @Autowired
    LoginCustRepository loginCustRepository;
    @Test
    void contextLoads() {
//        long cnt = loginCustRepository.count();
//        log.info("Count------------------------"+cnt);

        Iterable<LoginCust> list =  loginCustRepository.findAll();
        List<LoginCust> loginlist = new ArrayList<>();

        list.forEach(loginCust -> {
            if(loginCust != null){
                loginlist.add(loginCust);
            }
        });
        log.info("Count:"+loginlist.size());
    }

}
