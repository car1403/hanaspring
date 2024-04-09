package com.hana.controller;

import com.github.pagehelper.PageInfo;
import com.hana.app.data.dto.CustDto;
import com.hana.app.service.CustService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/cust")
@RequiredArgsConstructor
public class CustController {
    String dir= "cust/";

    final CustService custService;
    @RequestMapping("/")
    public String main(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center",dir+"center");
        return "index";
    }
    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("left", dir+"left");
        model.addAttribute("center",dir+"add");
        return "index";
    }
    @RequestMapping("/addimpl")
    public String addimpl(Model model, CustDto custDto){

        try {
            custService.add(custDto);
        } catch (Exception e) {
            //throw new RuntimeException(e);
            model.addAttribute("left", dir+"left");
            model.addAttribute("center",dir+"registerfail");
            return "index";
        }

        return "redirect:/cust/detail?id="+custDto.getId();
    }
    @RequestMapping("/detail")
    public String detail(Model model,@RequestParam("id") String id){
        CustDto custDto = null;
        try {
            custDto = custService.get(id);
            model.addAttribute("cust", custDto);
            model.addAttribute("left", dir+"left");
            model.addAttribute("center",dir+"detail");
        } catch (Exception e) {
            //throw new RuntimeException(e);
            model.addAttribute("left", dir+"left");
            model.addAttribute("center","registerfail");
        }
        return "index";
    }
    @RequestMapping("/get")
    public String get(Model model){
        List<CustDto> list = null;
        try {
            list = custService.get();
            model.addAttribute("custs", list);
            model.addAttribute("left", dir+"left");
            model.addAttribute("center",dir+"get");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "index";
    }
    @RequestMapping("/allpage")
    public String allpage(@RequestParam(value = "pageNo",defaultValue = "1") int pageNo, Model model){
        PageInfo<CustDto> p;
        try {
            p = new PageInfo<>(custService.getPage(pageNo), 5); // 5:하단 네비게이션 개수
            model.addAttribute("cpage", p);
            model.addAttribute("target", "/cust");
            model.addAttribute("left", dir+"left");
            model.addAttribute("center",dir+"allpage");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return "index";
    }


}
