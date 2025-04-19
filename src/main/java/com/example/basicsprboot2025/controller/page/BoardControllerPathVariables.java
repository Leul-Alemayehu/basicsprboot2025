package com.example.basicsprboot2025.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequestMapping("/board")
@Controller
public class BoardControllerPathVariables {

    @RequestMapping("/{action}")
    public String handleAction(@PathVariable String action) {
        return "board/" + action;
    }
}
