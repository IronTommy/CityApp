package com.korsakov.cityapp.controller;

import com.korsakov.cityapp.model.VKPostResponse;
import com.korsakov.cityapp.service.VKService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class VKController {

    private final VKService vkService;

    @Autowired
    public VKController(VKService vkService) {
        this.vkService = vkService;
    }

    @GetMapping("/vk-posts")
    public VKPostResponse getVKPosts(@RequestParam(value = "offset", defaultValue = "0") int offset,
                                     @RequestParam(value = "count", defaultValue = "10") int count) {
        long start = System.currentTimeMillis();
        VKPostResponse response = vkService.getVKPosts(offset, count);
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start) + "ms");
        return response;
    }
}
