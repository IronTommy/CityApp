package com.korsakov.cityapp.model;

import lombok.Data;
import java.util.List;

@Data
public class NewsResponse {
    private String status;
    private int totalResults;
    private List<NewsArticle> articles;
}
