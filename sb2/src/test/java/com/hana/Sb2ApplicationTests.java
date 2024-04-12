package com.hana;

import com.hana.util.StringEnc;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class Sb2ApplicationTests {


    @Test
    void contextLoads() {
        String text = "abc";
        String atext = StringEnc.encryptor(text);
        String aatext = StringEnc.decryptor(atext);

        log.info("----------LOG----------------"+atext);
        log.info("----------LOG----------------"+aatext);
    }

}
