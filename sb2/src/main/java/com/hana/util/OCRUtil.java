package com.hana.util;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class OCRUtil {
    public static JSONObject getResult(String imgpath, String imgname){
        JSONObject obj = null;

        String apiURL = "https://gojlwur9ps.apigw.ntruss.com/custom/v1/30139/704b9ad58d53e734f0f4affb9915de3a67949b656bbc82cba5fecc21a9d4f5f0/infer";
        String secretKey = "U3F4ck5pZXF0Y2t6aWphb3FHQWV3R056TWFXcW1CeWo=";
        String imageFile = imgpath+imgname;

        try {
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setUseCaches(false);
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setReadTimeout(30000);
            con.setRequestMethod("POST");
            String boundary = "----" + UUID.randomUUID().toString().replaceAll("-", "");
            con.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            con.setRequestProperty("X-OCR-SECRET", secretKey);

            JSONObject json = new JSONObject();
            json.put("version", "V2");
            json.put("requestId", UUID.randomUUID().toString());
            json.put("timestamp", System.currentTimeMillis());
            JSONObject image = new JSONObject();
            image.put("format", "jpg");
            image.put("name", "demo");
            JSONArray images = new JSONArray();
            images.add(image);
            json.put("images", images);
            String postParams = json.toString();

            con.connect();
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            long start = System.currentTimeMillis();
            File file = new File(imageFile);
            writeMultiPart(wr, postParams, file, boundary);
            wr.close();

            int responseCode = con.getResponseCode();
            BufferedReader br;
            if (responseCode == 200) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            JSONParser parser = new JSONParser();
            obj = (JSONObject) parser.parse(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }

        return obj;
    }

    private static void writeMultiPart(OutputStream out, String jsonMessage, File file, String boundary) throws
            IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("--").append(boundary).append("\r\n");
        sb.append("Content-Disposition:form-data; name=\"message\"\r\n\r\n");
        sb.append(jsonMessage);
        sb.append("\r\n");

        out.write(sb.toString().getBytes("UTF-8"));
        out.flush();

        if (file != null && file.isFile()) {
            out.write(("--" + boundary + "\r\n").getBytes("UTF-8"));
            StringBuilder fileString = new StringBuilder();
            fileString
                    .append("Content-Disposition:form-data; name=\"file\"; filename=");
            fileString.append("\"" + file.getName() + "\"\r\n");
            fileString.append("Content-Type: application/octet-stream\r\n\r\n");
            out.write(fileString.toString().getBytes("UTF-8"));
            out.flush();

            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] buffer = new byte[8192];
                int count;
                while ((count = fis.read(buffer)) != -1) {
                    out.write(buffer, 0, count);
                }
                out.write("\r\n".getBytes());
            }

            out.write(("--" + boundary + "--\r\n").getBytes("UTF-8"));
        }
        out.flush();
    }

    public static Map getData(JSONObject obj){
        Map<String,String> map = new HashMap<>();
        JSONArray images = (JSONArray) obj.get("images");
        JSONObject jo1 = (JSONObject) images.get(0);
        JSONArray fields = (JSONArray) jo1.get("fields");

//        JSONObject biznum_obj = (JSONObject) fields.get(0);
//        String biznum = (String)biznum_obj.get("inferText");

        JSONObject bizname_obj = (JSONObject) fields.get(0);
        String bizname = (String)bizname_obj.get("inferText");

        JSONObject bizowner_obj = (JSONObject) fields.get(1);
        String bizowner = (String)bizowner_obj.get("inferText");

        JSONObject bizdate_obj = (JSONObject) fields.get(2);
        String bizdate = (String)bizdate_obj.get("inferText");

        JSONObject bizadd_obj = (JSONObject) fields.get(3);
        String bizadd = (String)bizadd_obj.get("inferText");

//        map.put("biznum", biznum);
        map.put("bizname", bizname);
        map.put("bizowner", bizowner);
        map.put("bizdate", bizdate);
        map.put("bizadd", bizadd);

        return map;
    }


}
