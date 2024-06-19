package com.korsakov.cityapp.controller;

import com.korsakov.cityapp.model.NewsResponse;
import com.korsakov.cityapp.service.NewsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping
    public ResponseEntity<NewsResponse> getNews(@RequestParam(defaultValue = "ru") String country) {
        NewsResponse response = newsService.getNews(country);
        if (response.getStatus().equals("error")) {
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(response);
    }
}
