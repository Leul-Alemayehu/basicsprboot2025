package com.example.basicsprboot2025.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api")
@RestController
public class AssignmentRestController {

    @RequestMapping("assignment2")
    public Map assignment2(){
        Map<String,Object> someRandomMappings = new HashMap();
        someRandomMappings.put("ሀ","hä");
        someRandomMappings.put("Seventeen", 17);
        someRandomMappings.put("pi", 3.14159265);
        return someRandomMappings;
    }

    @RequestMapping("assignment3rest")
    public int assignment3rest(int num1, int num2, int num3){
        return num1+num2+num3;
    }
}
