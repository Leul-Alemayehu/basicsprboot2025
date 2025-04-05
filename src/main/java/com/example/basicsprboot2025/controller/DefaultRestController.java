package com.example.basicsprboot2025.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class DefaultRestController {

    @RequestMapping("/getone")
    public int getone() {
        return 1;
    }

    @RequestMapping("/getparamsback")
    public String getparamsback(@RequestParam String param) {
        return param;
    }

    @RequestMapping("/getstrs")
    public String[] getstrs() {
        return new String[]{"one", "two", "three"};
    }


}
