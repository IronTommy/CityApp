package com.korsakov.cityapp.model;

import lombok.Data;

@Data
public class NewsArticle {
    private String title;
    private String description;
    private String url;
    private String urlToImage;
    private Source source;

    @Data
    public static class Source {
        private String name;
    }
}
