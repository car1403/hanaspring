package com.hana.controller;

import com.hana.app.data.dto.ItemDto;
import com.hana.app.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/item")
@RequiredArgsConstructor
@Slf4j
public class ItemController {

    private final ItemService itemService;
    String dir = "item/";

    @RequestMapping("/add")
    public String add(Model model) throws Exception {
        model.addAttribute("center",dir+"add");
        return "index";
    }
    @RequestMapping("/addimpl")
    public String addimpl(Model model, ItemDto itemDto) throws Exception {

        log.info(itemDto.toString());

        model.addAttribute("center",dir+"add");
        return "index";
    }

    @RequestMapping("/get")
    public String get(Model model) throws Exception {
        List<ItemDto> list = new ArrayList<>();
        try {
            list = itemService.get();
            model.addAttribute("itemlist",list);
            model.addAttribute("center",dir+"get");
        } catch (Exception e) {
            throw new Exception("EI0001");
        }

        return "index";
    }
    @RequestMapping("/detail")
    public String detail(Model model, @RequestParam("id") int id) throws Exception {
        ItemDto itemDto = null;
        try {
            itemDto = itemService.get(id);
            model.addAttribute("item",itemDto);
            model.addAttribute("center",dir+"detail");
        } catch (Exception e) {
            throw new Exception("EI0001");
        }

        return "index";
    }
}
