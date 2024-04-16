package com.hana.ncp;

import com.hana.util.NcpUtil;
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

@Slf4j
@SpringBootTest
class SummaryTests {
    @Value("${app.key.ncp-id}")
    String ncpId;
    @Value("${app.key.ncp-secret}")
    String ncpSecret;

    @Test
    void contextLoads() {
        try {
            String text = "수업 재개를 계획했던 의과대학 다수가 학사 일정을 다시 미루고 있다. 앞서 정부의 의대 증원 방침에 반발한 의대생들이 수업을 거부하자 대학은 지난 2월부터 휴강을 이어왔다. 그러다 집단 유급 '한계선'에 도달한 대학들은 지난 4일부터 수업을 재개하고 있다. 하지만 의대 증원을 둘러싼 갈등이 지속되고 있고 학생들의 출석률도 저조해 학사 일정을 다시 미루는 학교들이 생겼다.";

            String apiURL = "https://naveropenapi.apigw.ntruss.com/text-summary/v1/summarize"; //
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json;UTF-8");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", ncpId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", ncpSecret);
            // post request
            //  String postParams = "content=" + text;
            con.setDoOutput(true);

            JSONObject jsonObject = new JSONObject();

            JSONObject documentObject = new JSONObject();
            documentObject.put("content",text);

            JSONObject optionObject = new JSONObject();
            optionObject.put("language","ko");
            optionObject.put("model","news");
            optionObject.put("summaryCount",2);

            jsonObject.put("document",documentObject);
            jsonObject.put("option",optionObject);


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
            System.out.println(response.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
