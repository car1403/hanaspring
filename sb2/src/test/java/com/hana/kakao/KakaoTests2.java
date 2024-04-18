package com.hana.kakao;

import com.hana.util.KoGPTUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

@SpringBootTest
@Slf4j
class KakaoTests2 {

    @Value("${app.key.kakao_rest_key}")
    String key;

    @Test
    void contextLoads() throws Exception {
        String msg = "오늘 먼지가 많네";

        String result = KoGPTUtil.getMsg(key,msg);
        log.info(result);
    }

}
