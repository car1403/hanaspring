package com.hana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainContoller {
    @RequestMapping("/")
    public String main(){
        return "index";
    }
    @RequestMapping("/board")
    public String board(Model model){
        model.addAttribute("center","board");
        return "index";
    }
}
