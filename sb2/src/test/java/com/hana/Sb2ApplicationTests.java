package com.hana;

import com.hana.app.data.dto.CustDto;

import com.hana.util.StringEnc;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class Sb2ApplicationTests {


    @Test
    void contextLoads() {
        String text = "abc";
        String atext = StringEnc.encryptor(text);
        String aatext = StringEnc.decryptor(atext);


    }

}
