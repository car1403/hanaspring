package com.hana.controller;

import com.hana.app.data.dto.AdminDto;
import com.hana.app.service.AdminService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {

    private final AdminService adminService;

    @RequestMapping("/")
    public String main(){
        return "index";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession){
        if(httpSession != null){
            httpSession.invalidate();
        }
        return "index";
    }
    @RequestMapping("/loginimpl")
    public String loginimpl(
            @RequestParam("id") String id,
            @RequestParam("pwd") String pwd,
            HttpSession httpSession){
        AdminDto adminDto = null;

        try {
            adminDto = adminService.get(id);
            if(adminDto == null){
                throw new Exception();
            }
            if(!adminDto.getPwd().equals(pwd)){
                throw new Exception();
            }
            httpSession.setAttribute("admin",adminDto);
        } catch (Exception e) {
            return "index";
        }

        return "redirect:/";
    }
}
