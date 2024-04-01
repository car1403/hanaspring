package com.hana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jquery")
public class JqueryController {
    String dir= "jquery/";
    @RequestMapping("/")
    public String main(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center",dir+"center");
        return "index";
    }
    @RequestMapping("/jquery1")
    public String jquery1(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center",dir+"jquery1");
        return "index";
    }
    @RequestMapping("/jquery2")
    public String jquery2(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center",dir+"jquery2");
        return "index";
    }
    @RequestMapping("/jquery3")
    public String jquery3(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center",dir+"jquery3");
        return "index";
    }
}
