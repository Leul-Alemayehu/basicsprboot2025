package com.example.basicsprboot2025.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/postboard")
@Controller
public class PostController {
    @RequestMapping("/create")
    public String create() {
        return "postboard/create";
    }

    @RequestMapping("/list")
    public String list() {
        return "postboard/list";
    }

    @RequestMapping("/read")
    public String read() {
        return "postboard/read";
    }

    @RequestMapping("/update")
    public String update() {
        return "postboard/update";
    }

    @RequestMapping("/delete")
    public String delete() {
        return "postboard/delete";
    }
}
