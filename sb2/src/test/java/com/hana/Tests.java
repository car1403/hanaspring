package com.hana;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class Tests {

    @Test
    void contextLoads() {
        try {
            Object str = WeatherUtil.getWeather3("");
            log.info("----------LOG----------------");
            log.info(str.toString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
