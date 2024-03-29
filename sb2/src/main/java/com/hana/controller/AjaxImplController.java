package com.hana.controller;

import com.hana.app.data.dto.CustDto;
import com.hana.app.data.dto.ShopDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class AjaxImplController {
    @RequestMapping("/getservertime")
    public Object getservertime(){
        Date date = new Date();
        return date;
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
