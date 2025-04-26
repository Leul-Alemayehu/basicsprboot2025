package com.example.basicsprboot2025.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/spost")
@Controller
public class SpostPageController {
    @RequestMapping("/{page}")
    public String page(@PathVariable String page) {
        return "spost/" + page;
    }

    @RequestMapping("/{page}/{id}")
    public String page(@PathVariable String page, @PathVariable int id) {
        return "spost/" + page;
    }
}
