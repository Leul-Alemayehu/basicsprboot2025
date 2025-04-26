package com.example.basicsprboot2025.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface SboardService {
    Map<String,Object> create(Map<String,Object> map);
    List<Map<String,Object>> list(String filter);
    Map<String,Object> read(int id);
    void update(int id, String title, String content, String author);
    void delete(int id);
}
