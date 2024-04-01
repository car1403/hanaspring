package com.hana.controller;

import com.hana.app.data.dto.CustDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/html")
public class HtmlController {
    String dir= "html/";
    @RequestMapping("/")
    public String main(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center",dir+"center");
        return "index";
    }
    @RequestMapping("/html1")
    public String html1(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center",dir+"html1");
        return "index";
    }
    @RequestMapping("/html2")
    public String html2(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center",dir+"html2");
        return "index";
    }
    @RequestMapping("/html3")
    public String html3(Model model){
        // Data를 DB에서 조회 한다.
        List<CustDto> list = new ArrayList<>();
        list.add(new CustDto("id01","pwd01","james"));
        list.add(new CustDto("id01","pwd01","james"));
        list.add(new CustDto("id01","pwd01","james"));
        list.add(new CustDto("id01","pwd01","james"));
        list.add(new CustDto("id01","pwd01","james"));

        model.addAttribute("custs", list);
        model.addAttribute("left", dir+"left");
        model.addAttribute("center",dir+"html3");
        return "index";
    }
}
