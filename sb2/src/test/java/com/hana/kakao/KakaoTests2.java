package com.hana.kakao;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
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
        String apiURL = "https://api.kakaobrain.com/v1/inference/kogpt/generation";
        URL url = new URL(apiURL);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json;UTF-8");
        con.setRequestProperty("Authorization", "KakaoAK " + key);	//Property 설정

        // post request
        //  String postParams = "content=" + text;
        con.setDoOutput(true);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("prompt","오늘 아침 하늘은 곧 비가 올 것 같아서");
        jsonObject.put("max_tokens",120);


        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.write(jsonObject.toString().getBytes("UTF-8"));
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        BufferedReader br;
        if(responseCode==200) { // 정상 호출
            br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        } else {  // 오류 발생
            br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
        }
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = br.readLine()) != null) {
            response.append(inputLine);
        }
        br.close();
        log.info(response.toString());






    }

}
