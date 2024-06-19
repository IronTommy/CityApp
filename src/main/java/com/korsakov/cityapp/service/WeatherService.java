package com.korsakov.cityapp.service;

import com.korsakov.cityapp.model.ForecastResponse;
import com.korsakov.cityapp.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;
    private final String apiKey;
    private static final Logger logger = Logger.getLogger(WeatherService.class.getName());

    private static final String WEATHER_URL_TEMPLATE = "http://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric&lang=%s";
    private static final String FORECAST_URL_TEMPLATE = "http://api.openweathermap.org/data/2.5/forecast?q=%s&appid=%s&units=metric&lang=%s";

    public WeatherService(RestTemplate restTemplate, @Value("${openweathermap.api.key}") String apiKey) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
    }

    @Cacheable("weather")
    public WeatherResponse getWeather(String city, String lang) {
        String url = String.format(WEATHER_URL_TEMPLATE, city, apiKey, lang);
        logger.info("Request URL: " + url);
        return getWeatherResponse(url);
    }

    @Cacheable("forecast")
    public ForecastResponse getForecast(String city, String lang) {
        String url = String.format(FORECAST_URL_TEMPLATE, city, apiKey, lang);
        logger.info("Request URL: " + url);
        return getForecastResponse(url);
    }

    private WeatherResponse getWeatherResponse(String url) {
        try {
            return restTemplate.getForObject(url, WeatherResponse.class);
        } catch (HttpClientErrorException e) {
            return handleWeatherHttpClientErrorException(e);
        }
    }

    private ForecastResponse getForecastResponse(String url) {
        try {
            return restTemplate.getForObject(url, ForecastResponse.class);
        } catch (HttpClientErrorException e) {
            logger.severe("Error response: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
            ForecastResponse errorResponse = new ForecastResponse();
            if (e.getStatusCode() == HttpStatus.UNAUTHORIZED) {
                errorResponse.setCod("401");
                errorResponse.setMessage("Invalid API key");
            } else if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                errorResponse.setCod("404");
                errorResponse.setMessage("City not found");
            } else {
                errorResponse.setCod(String.valueOf(e.getStatusCode().value()));
                errorResponse.setMessage(e.getStatusText());
            }
            return errorResponse;
        }
    }

    private WeatherResponse handleWeatherHttpClientErrorException(HttpClientErrorException e) {
        logger.severe("Error response: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
        WeatherResponse errorResponse = new WeatherResponse();
        errorResponse.setCod(e.getStatusCode().value());
        errorResponse.setName(e.getStatusText());
        return errorResponse;
    }
}
