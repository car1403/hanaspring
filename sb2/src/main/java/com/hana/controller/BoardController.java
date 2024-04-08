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
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    String dir= "board/";

    @RequestMapping("/get")
    public String get(Model model){
        model.addAttribute("center",dir+"get");
        return "index";
    }
    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("center",dir+"add");
        return "index";
    }

}
