package com.hana.controller;

import com.hana.app.data.dto.BoardDto;
import com.hana.app.data.dto.CustDto;
import com.hana.app.data.entity.LoginCust;
import com.hana.app.repository.LoginCustRepository;
import com.hana.app.service.BoardService;
import com.hana.app.service.CustService;
import com.hana.util.StringEnc;
import com.hana.util.WeatherUtil;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;
import java.util.Random;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {

    final CustService custService;
    final BoardService boardService;
    final BCryptPasswordEncoder encoder;
    final LoginCustRepository loginCustRepository;


    @Value("${app.key.wkey}")
    String wkey;
    @Value("${app.key.whkey}")
    String whkey;
    @Value("${app.url.serverurl}")
    String serverurl;

    @RequestMapping("/")
    public String main(Model model) throws Exception {
        Random r = new Random();
        int num = r.nextInt(1000)+1;
        List<BoardDto> list = null;
        try{
            list = boardService.getRank();
        }catch (Exception e){
            model.addAttribute("ranks",null);
        }
        model.addAttribute("ranks",list);
        return "index";
    }

    @RequestMapping("/login")
    public String login(Model model){
        model.addAttribute("center","login");
        return "index";
    }
    @RequestMapping("/weather")
    public String weather(Model model){
        model.addAttribute("center","weather");
        return "index";
    }
    @RequestMapping("/chat")
    public String chat(Model model){
        model.addAttribute("serverurl",serverurl);
        model.addAttribute("center","chat");
        return "index";
    }
    @RequestMapping("/wh")
    @ResponseBody
    public Object wh(Model model) throws IOException, ParseException {
        return WeatherUtil.getWeather("109", wkey);
    }
    @RequestMapping("/wh2")
    @ResponseBody
    public Object wh2(Model model) throws IOException, ParseException {
        return WeatherUtil.getWeather2("1835848", whkey);
    }

    @RequestMapping("/logoutimpl")
    public String logoutimpl(Model model, HttpSession httpSession){
        log.info("start Logout --------------------------------------");
        if(httpSession != null){
            loginCustRepository.deleteById((String) httpSession.getAttribute("id"));
            httpSession.invalidate();
        }
        log.info("end Logout --------------------------------------");

        return "index";
    }
    @RequestMapping("/loginimpl")
    public String loginimpl(Model model,
                            @RequestParam("id") String id,
                            @RequestParam("pwd") String pwd, HttpSession httpSession){
        CustDto custDto = null;
        try {
            custDto = custService.get(id);
            if(custDto == null){
                throw new Exception();
            }
            if(!encoder.matches(pwd,custDto.getPwd())){
                throw new Exception();
            }

            loginCustRepository.save(LoginCust.builder().loginId(id).build());

            httpSession.setAttribute("id", id);

        } catch (Exception e){
            model.addAttribute("msg","ID또는 PWD가 틀렸습니다.");
            model.addAttribute("center","login");
            //throw new RuntimeException(e);
        }
        return "redirect:/";
    }

    @RequestMapping("/registerimpl")
    public String registerimpl(Model model,
                               CustDto custDto, HttpSession httpSession){

        try {
            //log.info(encoder.encode(custDto.getPwd()));
            //log.info(encoder.encode(custDto.getPwd()).length()+"");
            custDto.setPwd(encoder.encode(custDto.getPwd()));
            custDto.setName(StringEnc.encryptor(custDto.getName()));
            custService.add(custDto);
            loginCustRepository.save(LoginCust.builder().loginId(custDto.getId()).build());

            httpSession.setAttribute("id", custDto.getId());
        } catch (Exception e) {
            //throw new RuntimeException(e);
            model.addAttribute("center","registerfail");
        }


        return "index";
    }
    @RequestMapping("/register")
    public String register(Model model){
        model.addAttribute("center","register");
        return "index";
    }

    @ResponseBody
    @RequestMapping("/registercheckid")
    public Object registercheckid(@RequestParam("id") String id) throws Exception {
        String result = "0";
        CustDto custDto = custService.get(id);
        if(custDto == null){
            result = "1";
        }
        return result;
    }

}
