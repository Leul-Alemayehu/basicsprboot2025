package com.example.basicsprboot2025.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class DefaultController {

    @ResponseBody
    @RequestMapping("/test")
    public String test(){
        return "This is a test message";
    }

    @ResponseBody
    @RequestMapping("/test2")
    public ArrayList<String> test2(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("This is a test message");
        list.add("This is another test message");
        list.add("This is the third test message");
        list.add("This is the fourth test message");
        return list;
    }

}
