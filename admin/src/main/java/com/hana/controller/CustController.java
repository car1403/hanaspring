package com.hana.controller;

import com.hana.app.data.dto.CustDto;
import com.hana.app.data.entity.LoginCust;
import com.hana.app.repository.LoginCustRepository;
import com.hana.app.service.CustService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cust")
@RequiredArgsConstructor
public class CustController {

    final CustService custService;
    final LoginCustRepository loginCustRepository;

    String dir = "cust/";
    @RequestMapping("/get")
    public String get(Model model) throws Exception {
        // Database에서 데이터를 가지고 온다.
        List<CustDto> list = new ArrayList<>();
        try {
            list = custService.get();
            model.addAttribute("custs",list);
            model.addAttribute("center",dir+"get");
        } catch (Exception e) {
            throw new Exception("ER0001");
        }
        return "index";
    }
    @RequestMapping("/add")
    public String add(Model model){

        model.addAttribute("center",dir+"add");
        return "index";
    }
    @RequestMapping("/logininfo")
    public String logininfo(Model model){
        Iterable<LoginCust> it = loginCustRepository.findAll();
        List<LoginCust> list = new ArrayList<>();
        it.forEach(lc->{
            if(lc != null){
                list.add(lc);
            }
        });
        model.addAttribute("logincusts",list);
        model.addAttribute("cnt",list.size());
        model.addAttribute("center",dir+"logininfo");
        return "index";
    }

    @RequestMapping("/detail")
    public String detail(Model model,@RequestParam("id") String id){
        // Database에서 데이터를 가지고 온다.
        CustDto custDto = null;
        try {
            custDto = custService.get(id);
            model.addAttribute("cust", custDto);
            model.addAttribute("center",dir+"detail");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "index";
    }
    @RequestMapping("/update")
    public String update(Model model,CustDto custDto){

        try {
            custService.modify(custDto);
            return "redirect:/cust/detail?id="+custDto.getId();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @RequestMapping("/addimpl")
    public String addimpl(Model model,CustDto custDto) throws Exception {
        custService.add(custDto);
        return "redirect:/cust/detail?id="+custDto.getId();

    }
    @RequestMapping("/delete")
    public String delete(Model model,@RequestParam("id") String id){

        try {
            custService.del(id);
            return "redirect:/cust/get";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
