package com.example.basicsprboot2025.controller;

import com.example.basicsprboot2025.domain.Sboard;
import com.example.basicsprboot2025.service.SboardService;
import com.example.basicsprboot2025.service.SboardService2;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/sboard")
@RestController
public class SboardRestController {

    SboardService sboardService;
    final SboardService2 sboardService2;
    SboardRestController(SboardService sboardService, SboardService2 sboardService2) {
        this.sboardService = sboardService;
        this.sboardService2 = sboardService2;
    }

    @RequestMapping("/create")
    public Map<String, Object> create(@RequestBody Map<String,Object> param){
        Map<String,Object> ret = sboardService2.create(param);
        return ret;
    }

    /*@RequestMapping("/list")
    public List<Map<String, Object>> list(String filter){
        return sboardService.list(filter);
    }*/
    @RequestMapping("/list")
    public List<Sboard> list(String filter) {
        return sboardService2.list(filter);
    }

    /*@RequestMapping("/read/{id}")
    public Map<String, Object> read(@PathVariable int id) {
        System.out.println("Reading...");
        return sboardService.read(id);
    }*/
    @RequestMapping("/read/{id}")
    public Sboard read(@PathVariable int id) {
        System.out.println("Reading...");
        return sboardService2.read(id);
    }

    @RequestMapping("/update/{id}")
    public void update(@PathVariable int id, String title, String content, String author) {
        sboardService2.update(id,title,content,author);
    }

    @RequestMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        sboardService2.delete(id);
    }
}
