package com.example.basicsprboot2025.service;

import com.example.basicsprboot2025.domain.Sboard;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface SboardService2 {
    Map<String,Object> create(Map<String,Object> map);
    List<Sboard> list(String filter);
    Sboard read(int id);
    void update(int id, String title, String content, String author);
    void delete(int id);
}
