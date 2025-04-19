package com.example.basicsprboot2025.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/board")
@RestController
public class BoardRestControllerPathVariables {

    int latestid = 0;
    ArrayList<Map<String, Object>> tempdata = new ArrayList<>();

    @RequestMapping("/create")
    public Map<String, Object> create(String title, String content, String author) {
        Map<String, Object> map = new HashMap<>();
        System.out.println("Title: " + title);
        map.put("title", title);
        map.put("content", content);
        map.put("author", author);
        map.put("id", ++latestid);

        tempdata.add(map);
        return map;
    }

    @RequestMapping("/list")
    public ArrayList<Map<String, Object>> list() {
        return tempdata;
    }

    @RequestMapping("/read/{id}")
    public Map<String, Object> read(@PathVariable int id) {
        System.out.println("Reading...");
        for(Map<String, Object> map : tempdata) {
            if(map.get("id").equals(id)) {
                System.out.println(map.get("title") + " Found!");
                return map;
            }
        }
        return null;
    }

    @RequestMapping("/update/{id}")
    public void update(@PathVariable int id, String title, String content, String author) {
        for(Map<String, Object> map : tempdata) {
            if(map.get("id").equals(id)) {
                map.put("title", title);
                map.put("content", content);
                map.put("author", author);
            }
        }
    }

    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        tempdata.removeIf(map -> map.get("id").equals(id));
    }
}
