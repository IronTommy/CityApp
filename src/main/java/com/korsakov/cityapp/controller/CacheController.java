package com.korsakov.cityapp.controller;

import com.korsakov.cityapp.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cache")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @GetMapping("/save")
    public String saveToCache() {
        cacheService.save("myKey", "myValue");
        return "Saved to cache";
    }

    @GetMapping("/get")
    public String getFromCache() {
        return (String) cacheService.get("myKey");
    }
}
