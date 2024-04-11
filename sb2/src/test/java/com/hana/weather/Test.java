package com.hana.weather;

import com.hana.util.WeatherUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
@Slf4j
class Test {

    @org.junit.jupiter.api.Test
    void contextLoads() throws IOException, ParseException {
        String key = "C2YXvxKurZ%2FmXrbnFlyub5B89GCCWUmYncj4wvNqlWzyP0IwmeP%2FAVl1mU3Tz7Kzk8mfT3f6Wm2wJJ9Z6yNjgw%3D%3D";
        String loc = "109";
        JSONObject jsonObject = (JSONObject) WeatherUtil.getWeather(loc, key);

        log.info("----------LOG1----------------"+jsonObject.toJSONString());

        String key2 = "5f8cdbafcfe5dd8a4edbbe08e8d21e3d";
        String loc2 = "1835848";
        JSONObject jsonObject2 = (JSONObject) WeatherUtil.getWeather2(loc2, key2);
        log.info("----------LOG2----------------"+jsonObject2.toJSONString());

    }

}
