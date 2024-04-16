package com.hana.ncp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import com.hana.util.NcpUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class SentimentTests {
    @Value("${app.key.ncp-id}")
    String ncpId;
    @Value("${app.key.ncp-secret}")
    String ncpSecret;

    @Test
    void contextLoads() {
       String text = "오늘은 참 비도 오고 거시기 하네";
       JSONObject obj = (JSONObject) NcpUtil.getSentiment(ncpId, ncpSecret, text);
       log.info(obj.toJSONString());
    }

}
