package com.hana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @RequestMapping("/")
    public String main(Model m){
        List<String> list = new ArrayList<>();
        list.add("DATA1");
        list.add("DATA2");
        list.add("DATA3");
        m.addAttribute("data","MyData");
        m.addAttribute("datas",list);
        return "index";
    }
}
