package com.hana.kakao;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@SpringBootTest
@Slf4j
class KakaoTests3 {

    @Value("${app.key.kakao_rest_key}")
    String key;

    @Test
    void contextLoads() throws Exception {
        String apiURL = "https://api.kakaobrain.com/v2/inference/karlo/t2i";
        URL url = new URL(apiURL);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json;UTF-8");
        con.setRequestProperty("Authorization", "KakaoAK " + key);	//Property 설정

        // post request
        //  String postParams = "content=" + text;
        con.setDoOutput(true);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("version","v2.1");
        jsonObject.put("prompt","바닷가에 귀여운 꼬마");
        jsonObject.put("height",1024);
        jsonObject.put("width",1024);


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
