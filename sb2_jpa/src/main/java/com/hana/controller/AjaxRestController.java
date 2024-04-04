package com.hana.controller;

import com.hana.app.data.dto.Chart2Dto;
import com.hana.app.data.dto.CustDto;
import com.hana.app.data.dto.ShopDto;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j

public class AjaxRestController {

    private String aa;

    public AjaxRestController() {
        log.info("start ---------");
        aa ="aaaa";
    }

    @RequestMapping("/getservertime")
    public Object getservertime(){
        Date date = new Date();

        log.info(this.aa+ "---------");
        return date;
    }
    @RequestMapping("/chart2")
    public Object chart2(){
        JSONArray ja = new JSONArray();

        List<Chart2Dto> list = new ArrayList<>();
        // [{"name":"S001","m1":10,....},{},{},{}]
        list.add(new Chart2Dto("S001",10,20,30,20,10,15));
        list.add(new Chart2Dto("S002",13,30,60,10,10,25));
        list.add(new Chart2Dto("S003",11,10,70,80,15,35));
        list.add(new Chart2Dto("S004",18,20,20,90,22,45));

        list.stream().forEach(c->{
            JSONObject jo = new JSONObject();
            jo.put("name",c.getName());
            jo.put("data",c.getM());
            ja.add(jo);
        });

//        for(Chart2Dto c:list){
//
//        }
        return ja;
    }
    @RequestMapping("/chart4")
    public Object chart4(@RequestParam("gender") String gender){
        JSONArray ja = new JSONArray();

        List<Chart2Dto> list = new ArrayList<>();
        // [{"name":"S001","m1":10,....},{},{},{}]
        list.add(new Chart2Dto("f",30,10,10,10,20,20));
        list.add(new Chart2Dto("m",40,10,10,10,10,20));

        list.stream().filter(c-> c.getName().equals(gender)).forEach(c->{
            c.getM().stream().forEach(n->{
                JSONArray ja2 = new JSONArray();
                // [["",20],[],[],[]]
                ja2.add("OTT");
                ja2.add(n);
                ja.add(ja2);
            });
        });
        //{"data:":[], "title":"f"}
        JSONObject jo = new JSONObject();
        jo.put("data",ja);
        jo.put("title",gender);
        return jo;
    }
    @RequestMapping("/geo/getdata")
    public Object geogetdata(){
        List<ShopDto> list = new ArrayList<>();
        list.add(new ShopDto(100,"순대국","a.jpg",37.5547611, 127.0654625));
        list.add(new ShopDto(101,"파스타","b.jpg",37.5747611, 127.0554625));
        list.add(new ShopDto(102,"햄버거","c.jpg",37.5147611, 127.0154625));

        return list;
    }
    @RequestMapping("/getdata")
    public Object getdata(){
        List<CustDto> list = new ArrayList<>();
        list.add(new CustDto("id01","pwd01","james"));
        list.add(new CustDto("id01","pwd01","james"));
        list.add(new CustDto("id01","pwd01","james"));
        list.add(new CustDto("id01","pwd01","james"));
        list.add(new CustDto("id01","pwd01","james"));
        return list;
    }
    @RequestMapping("/checkid")
    public Object checkid(@RequestParam("id") String id){
        String result = "1";
        if(id.equals("qqq")){
            result = "0";
        }
        return result;
    }
}
