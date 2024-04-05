package com.hana.exception;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionController {
    @ExceptionHandler(Exception.class)
    public String except(Exception e, Model model){
        model.addAttribute("msg", e.getMessage());
        model.addAttribute("center", "error");
        return "index";
    }
    @ExceptionHandler(DuplicateKeyException.class)
    public String except2(DuplicateKeyException e, Model model){
        model.addAttribute("msg", "DuplicateKeyException:");
        model.addAttribute("center", "error");
        return "index";
    }
}
