package com.example.basicsprboot2025.service.impl;

import com.example.basicsprboot2025.domain.Sboard;
import com.example.basicsprboot2025.repository.SboardRepository;
import com.example.basicsprboot2025.service.SboardService2;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SboardService2Impl implements SboardService2 {

    final SboardRepository sboardRepository;
    public SboardService2Impl(SboardRepository sboardRepository) {
        this.sboardRepository = sboardRepository;
    }

    @Override
    public Map<String, Object> create(Map<String, Object> map) {
        String title = (String) map.get("title");
        String content = (String) map.get("content");
        String author = (String) map.get("author");

        Sboard sboard = new Sboard(title, content, author);
        sboardRepository.save(sboard);

        Map<String, Object> result = new HashMap<>();
        result.put("id", sboard.getId());
        result.put("responseCode", 200);

        return result;
    }

    @Override
    public List<Sboard> list(String filter) {
        // filter ignored for now
        List<Sboard> result = new ArrayList<>();
        result = sboardRepository.findAll();
        return result;
    }

    @Override
    public Sboard read(int id) {
        long tempId = id;
        Sboard sboard = sboardRepository.findById(tempId).orElse(null);
        return sboard;
    }

    @Override
    public void update(int id, String title, String content, String author) {
        long tempId = id;
        Sboard sboard = sboardRepository.findById(tempId).orElse(null);
        if(sboard != null) {
            if (title != null) {
                sboard.setTitle(title);
            }
            if (content != null) {
                sboard.setContent(content);
            }
            if (author != null) {
                sboard.setAuthor(author);
            }
            sboardRepository.save(sboard);
        }
    }

    @Override
    public void delete(int id) {
        long tempId = id;
        Sboard sboard = sboardRepository.findById(tempId).orElse(null);
        if(sboard != null) {
            sboardRepository.delete(sboard);
        }
    }
}
