package com.example.basicsprboot2025.controller;

import com.example.basicsprboot2025.service.SboardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/sboard")
@RestController
public class SboardRestController {

    SboardService sboardService;
    SboardRestController(SboardService sboardService) {
        this.sboardService = sboardService;
    }

    @RequestMapping("/create")
    public Map<String, Object> create(@RequestBody Map<String,Object> param){
        Map<String,Object> ret = sboardService.create(param);
        return ret;
    }

    @RequestMapping("/list")
    public List<Map<String, Object>> list(String filter){
        return sboardService.list(filter);
    }

    @RequestMapping("/read/{id}")
    public Map<String, Object> read(@PathVariable int id) {
        System.out.println("Reading...");
        return sboardService.read(id);
    }

    @RequestMapping("/update/{id}")
    public void update(@PathVariable int id, String title, String content, String author) {
        sboardService.update(id,title,content,author);
    }

    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        sboardService.delete(id);
    }
}
