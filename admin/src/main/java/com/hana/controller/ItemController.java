package com.hana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/item")
public class ItemController {
    String dir = "item/";
    @RequestMapping("/get")
    public String get(Model model){
        model.addAttribute("center",dir+"get");
        return "index";
    }
}
