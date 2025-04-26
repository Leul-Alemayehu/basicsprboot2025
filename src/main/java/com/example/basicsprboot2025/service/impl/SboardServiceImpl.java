package com.example.basicsprboot2025.service.impl;

import com.example.basicsprboot2025.service.SboardService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class SboardServiceImpl implements SboardService {

    private final AtomicInteger latestId = new AtomicInteger(0);
    private final List<Map<String, Object>> tempdata = new ArrayList<>();

    @Override
    public Map<String,Object> create(Map<String, Object> mapParam) {
        Map<String, Object> retval = new HashMap<>();
        retval.put("id", latestId.incrementAndGet());
        retval.put("title", mapParam.get("title"));
        retval.put("content", mapParam.get("content"));
        retval.put("author", mapParam.get("author"));
        tempdata.add(retval);
        return retval;
    }

    @Override
    public List<Map<String, Object>> list(String filter) {
        if(filter == null || filter.isEmpty()){
            return tempdata;
        }
        List<Map<String, Object>> retval = new ArrayList<>();
        for(Map<String, Object> map : tempdata){
            if(map.get("title").toString().contains(filter)){
                retval.add(map);
            }
        }
        return retval;
    }

    @Override
    public Map<String, Object> read(int id) {
        for(Map<String, Object> map : tempdata) {
            if(map.get("id").equals(id)) {
                System.out.println(map.get("title") + " Found!");
                return map;
            }
        }
        return null;
    }

    @Override
    public void update(int id, String title, String content, String author) {
        for(Map<String, Object> map : tempdata){
            if(map.get("id").equals(id)){
                map.put("title", title);
                map.put("content", content);
                map.put("author", author);
            }
        }
    }

    @Override
    public void delete(int id) {
        tempdata.removeIf(map -> map.get("id").equals(id));
    }
}
