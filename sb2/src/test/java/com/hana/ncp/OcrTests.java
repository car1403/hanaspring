package com.hana.ncp;

import com.hana.util.OCRUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

@SpringBootTest
@Slf4j
class OcrTests {

    @Value("${app.dir.uploadimgdir}")
    String dir;

    @Test
    void contextLoads() {
        String imgname = "biz2.jpg";
        JSONObject jsonObject = (JSONObject) OCRUtil.getResult(dir,imgname);
        log.info(jsonObject.toJSONString());
        Map<String,String> map = OCRUtil.getData(jsonObject);
        map.values().forEach(txt->{log.info(txt);});

    }

}
