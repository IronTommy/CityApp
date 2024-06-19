package com.korsakov.cityapp.service;

import com.korsakov.cityapp.model.NewsResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.logging.Logger;

@Service
public class NewsService {

    private static final Logger logger = Logger.getLogger(NewsService.class.getName());
    private final RestTemplate restTemplate;
    private final String apiKey;
    private static final String NEWS_URL_TEMPLATE = "https://newsapi.org/v2/top-headlines?country=%s&apiKey=%s";

    public NewsService(RestTemplate restTemplate, @Value("${newsapi.api.key}") String apiKey) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
    }

    public NewsResponse getNews(String country) {
        String url = String.format(NEWS_URL_TEMPLATE, country, apiKey);
        NewsResponse response = restTemplate.getForObject(url, NewsResponse.class);

        if (response != null && response.getArticles() != null) {
            response.getArticles().forEach(article ->
                    logger.info("Image URL: " + article.getUrlToImage())
            );
        }

        return response;    }
}
