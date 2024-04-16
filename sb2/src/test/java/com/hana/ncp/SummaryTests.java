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
        String text = "개강을 다시 미룬 한 대학의 관계자는 \"(의대 증원 관련 갈등) 상황이 아직 정리되지 않아 섣불리 개강했다가 학생들이 수업일수를 채우지 못하면 그 피해가 고스란히 학생들에게 가기 때문\"이라며 이유를 설명했다. 수업을 재개해도 학생들이 수업을 빠지면 집단 유급 등 피해 가능성이 있다는 의미다.";
        JSONObject obj = (JSONObject) NcpUtil.getSummary(ncpId, ncpSecret, text);
        log.info(obj.toJSONString());
    }

}
