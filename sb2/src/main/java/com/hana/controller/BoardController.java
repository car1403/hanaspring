package com.hana.controller;

import com.hana.app.data.dto.BoardDto;
import com.hana.app.data.dto.CustDto;
import com.hana.app.service.BoardService;
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

    private final BoardService boardService;

    @RequestMapping("/get")
    public String get(Model model) throws Exception {
        List<BoardDto> list = null;
        list = boardService.get();
        model.addAttribute("boards",list);

        model.addAttribute("center",dir+"get");
        return "index";
    }
    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("center",dir+"add");
        return "index";
    }
    @RequestMapping("/addimpl")
    public String addimpl(Model model, BoardDto boardDto){

        try {
            boardService.add(boardDto);
        } catch (Exception e) {
            //throw new RuntimeException(e);
            model.addAttribute("center",dir+"registerfail");
            return "index";
        }

        return "redirect:/board/get";
    }
    @RequestMapping("/detail")
    public String detail(Model model,@RequestParam("id") int id){
        BoardDto boardDto = null;
        try {
            boardDto = boardService.get(id);
            model.addAttribute("board", boardDto);
            model.addAttribute("center",dir+"detail");
        } catch (Exception e) {
            //throw new RuntimeException(e);
            model.addAttribute("center","registerfail");
        }
        return "index";
    }
    @RequestMapping("/delete")
    public String delete(Model model,@RequestParam("id") int id){

        try {
            boardService.del(id);
            return "redirect:/board/get";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @RequestMapping("/update")
    public String update(Model model,BoardDto boardDto){

        try {
            boardService.modify(boardDto);
            return "redirect:/board/detail?id="+boardDto.getBoardId();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
