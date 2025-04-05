package com.example.basicsprboot2025.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class DefaultController {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

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

    @RequestMapping("/test001")
    public String test001(){
        return "test001";
    }

    @RequestMapping("/page1")
    public String page1(){
        return "page1";
    }

    @RequestMapping("/testmodel")
    public String testmodel(Model model){
        Integer[] underTens = {2,3,4,5};
        model.addAttribute("message", "A test is underway!");
        model.addAttribute("somesmallernums", underTens[1]);
        return "testmodel";
    }

    @RequestMapping("/testparameter")
    public String testparameter(int num, Model model){
        int result = 2*num;
        model.addAttribute("num", num);
        model.addAttribute("result", result);
        return "testparameter";
    }

    @RequestMapping("/testparameter2")
    public String testparameter2(int num1, int num2, Model model){
        int result = num1*num2;
        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        model.addAttribute("result", result);
        return "testparameter2";
    }

}
