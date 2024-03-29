package com.hana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/geo")
public class GeoController {
    String dir= "geo/";
    @RequestMapping("/")
    public String main(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center",dir+"center");
        return "index";
    }
    @RequestMapping("/geo1")
    public String geo1(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center",dir+"geo1");
        return "index";
    }
    @RequestMapping("/geo2")
    public String geo2(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center",dir+"geo2");
        return "index";
    }
    @RequestMapping("/geo3")
    public String geo3(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center",dir+"geo3");
        return "index";
    }
    @RequestMapping("/shopdetail")
    public String shopdetail(Model model,
                             @RequestParam("shopid") int shopid){
        model.addAttribute("shopid", shopid);
        model.addAttribute("left",dir+"left");
        model.addAttribute("center",dir+"detail");
        return "index";

    }
}
