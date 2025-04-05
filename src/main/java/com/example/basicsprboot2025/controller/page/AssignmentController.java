package com.example.basicsprboot2025.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AssignmentController {
    @RequestMapping("assignment1")
    public String assignment1(){
        return "assignment1";
    }


    @RequestMapping("assignment3page")
    public String assignment3page(int num1, int num2, int num3, Model model){
        int result = num1 + num2 + num3;

        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("num3", num3);
        model.addAttribute("result", result);
        return "assignment3page";
    }
}
