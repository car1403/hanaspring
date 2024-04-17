package com.hana.ncp;


import com.hana.util.ChatBotUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.Date;

@SpringBootTest
@Slf4j
class ChatBotTests {

    @Value("${app.key.chatbot_key}")
    private String secretKey;
    @Value("${app.key.chatbot_url}")
    private String apiUrl;

    @Test
    void contextLoads() throws Exception {
        String msg = "힘들겠네";
        String result = ChatBotUtil.getMsg(apiUrl,secretKey,msg);
        log.info(result);
    }


}
