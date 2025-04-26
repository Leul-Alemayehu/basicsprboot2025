package com.example.basicsprboot2025.controller;

import com.example.basicsprboot2025.service.SboardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequestMapping("/api/spost")
@RestController
public class SpostRestController {

    SboardService sboardService;
    SpostRestController(SboardService sboardService) {
        this.sboardService = sboardService;
    }

    @PostMapping("/create")
    public Map<String, Object> create(@RequestBody Map<String,Object> param){
        return sboardService.create(param);
    }

    @PostMapping("/list")
    public List<Map<String, Object>> list(@RequestBody Map<String, Object> param){
        String filter = param.getOrDefault("filter", "").toString();
        return sboardService.list(filter);
    }

    @PostMapping("/read")
    public Map<String, Object> read(@RequestBody Map<String, Object> param) {
        int id = (int) param.get("id");
        return sboardService.read(id);
    }

    @PostMapping("/update")
    public void update(@RequestBody Map<String, Object> param) {
        int id = (int) param.get("id");
        String title = (String) param.get("title");
        String content = (String) param.get("content");
        String author = (String) param.get("author");
        sboardService.update(id, title, content, author);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Map<String, Object> param) {
        int id = (int) param.get("id");
        sboardService.delete(id);
    }
}
