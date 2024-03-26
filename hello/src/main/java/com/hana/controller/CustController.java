package com.hana.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cust")
public class CustController {
    @RequestMapping("/info")
    public String main(Model m){

        return "cust/info";
    }
    @RequestMapping("/cust")
    public String cust(Model m){

        return "cust/cust";
    }
}
