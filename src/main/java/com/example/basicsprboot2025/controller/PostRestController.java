package com.example.basicsprboot2025.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/api/postboard")
public class PostRestController {

    private final AtomicInteger latestId = new AtomicInteger(0);
    private final List<Map<String, Object>> tempdata = new ArrayList<>();

    // CREATE
    @PostMapping("/create")
    public Map<String, Object> create(@RequestBody Map<String, Object> postData) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", latestId.incrementAndGet());
        map.put("title", postData.get("title"));
        map.put("content", postData.get("content"));
        map.put("author", postData.get("author"));
        tempdata.add(map);
        return map;
    }

    // LIST ALL
    @GetMapping("/list")
    public List<Map<String, Object>> list() {
        return tempdata;
    }

    // READ BY ID
    @GetMapping("/read")
    public Map<String, Object> read(@RequestParam int id) {
        return tempdata.stream()
                .filter(map -> id == (int) map.get("id"))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Post not found"));
    }

    // UPDATE
    @PutMapping("/update")
    public Map<String, Object> update(@RequestParam int id,
                                      @RequestParam String title,
                                      @RequestParam String content,
                                      @RequestParam String author) {
        for (Map<String, Object> map : tempdata) {
            if ((int) map.get("id") == id) {
                map.put("title", title);
                map.put("content", content);
                map.put("author", author);
                return map;
            }
        }
        throw new RuntimeException("Post not found for update");
    }

    // DELETE
    @DeleteMapping("/delete")
    public String delete(@RequestParam int id) {
        boolean removed = tempdata.removeIf(map -> (int) map.get("id") == id);
        if (removed) {
            return "Post deleted.";
        } else {
            throw new RuntimeException("Post not found for deletion");
        }
    }
}
