package com.example.basicsprboot2025.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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

    // Testing PathVariable Usage
    @RequestMapping("path/{testvar}")
    public Map<String,Object> path1(@PathVariable String testvar) {
        Map<String,Object> map = new HashMap<>();
        map.put("testvar", testvar);
        return map;
    }

    // Testing PathVariable Multiple Usage
    @RequestMapping("multipath/{testvar1}/{testvar2}")
    public Map<String,Object> path2(@PathVariable String testvar1, @PathVariable String testvar2) {
        Map<String,Object> map = new HashMap<>();
        map.put("testvar1", testvar1);
        map.put("testvar2", testvar2);
        map.put("appended", testvar1 + testvar2);
        return map;
    }

    // Testing PathVariable but variable identifier is different
    @RequestMapping("path2/{testvaragain}")
    public Map<String,Object> path3(@PathVariable("testvaragain") String msg) {
        System.out.println(msg);
        Map<String,Object> map = new HashMap<>();
        map.put("msg", msg);
        return map;
    }

    @RequestMapping("member/{teamId}/{memberId}")
    public Map<String,Object> member(@PathVariable("teamId") String teamId, @PathVariable("memberId") String memberId) {
        Map<String,Object> map = new HashMap<>();
        map.put("teamId", teamId);
        map.put("memberId", memberId);
        return map;
    }

}
