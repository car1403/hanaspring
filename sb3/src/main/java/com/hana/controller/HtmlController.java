package com.hana.controller;

import com.hana.app.data.dto.CustDto;
import com.hana.app.service.CustService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/html")
@RequiredArgsConstructor
public class HtmlController {
    String dir= "html/";

    final CustService custService;

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
        List<CustDto> list = null;

        try {
            list = custService.get();
            model.addAttribute("custs", list);
            model.addAttribute("left", dir+"left");
            model.addAttribute("center",dir+"html3");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "index";
    }

    @RequestMapping("/get")
    public String get(Model model, @RequestParam("id") String id){
        // id값을 DB에 조회 한다.
        CustDto c = CustDto.builder().id(id).pwd("pwdxx").name("james").build();

        model.addAttribute("cust", c);
        model.addAttribute("left", dir+"left");
        model.addAttribute("center",dir+"get");
        return "index";
    }
}
