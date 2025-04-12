package com.example.basicsprboot2025.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/board")
@Controller
public class BoardController {
    @RequestMapping("/create")
    public String create() {
        return "board/create";
    }

    @RequestMapping("/list")
    public String list() {
        return "board/list";
    }

    @RequestMapping("/read")
    public String read() {
        return "board/read";
    }

    @RequestMapping("/updatedelete")
    public String updatedelete() {
        return "board/updatedelete";
    }
}
