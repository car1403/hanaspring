package com.hana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ajax")
public class AjaxController {
    String dir= "ajax/";
    @RequestMapping("/")
    public String main(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center",dir+"center");
        return "index";
    }
    @RequestMapping("/ajax1")
    public String ajax1(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center",dir+"ajax1");
        return "index";
    }
    @RequestMapping("/ajax2")
    public String ajax2(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center",dir+"ajax2");
        return "index";
    }
    @RequestMapping("/ajax3")
    public String ajax3(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center",dir+"ajax3");
        return "index";
    }
}
