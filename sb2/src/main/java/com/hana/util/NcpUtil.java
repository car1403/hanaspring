package com.hana.util;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NcpUtil {

    public static Object getSentiment(String ncpId, String ncpSecret, String text){
        JSONParser jsonParser = new JSONParser();
        JSONObject returnObject = null;
        try {
            String apiURL = "https://naveropenapi.apigw.ntruss.com/sentiment-analysis/v1/analyze"; //
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
            jsonObject.put("content",text);


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
            returnObject = (JSONObject) jsonParser.parse(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnObject;
    }


    public static Object getSummary(String ncpId, String ncpSecret, String text){
        JSONParser jsonParser = new JSONParser();
        JSONObject returnObject = null;
        try {
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
            returnObject = (JSONObject) jsonParser.parse(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnObject;
    }
}
