package com.korsakov.cityapp.controller;

import com.korsakov.cityapp.model.ForecastResponse;
import com.korsakov.cityapp.model.WeatherResponse;
import com.korsakov.cityapp.service.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @GetMapping
    public ResponseEntity<WeatherResponse> getWeather(@RequestParam String city, @RequestParam(defaultValue = "en") String lang) {
        WeatherResponse response = weatherService.getWeather(city, lang);
        if (response.getCod() != 200) {
            return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCod()));
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/forecast")
    public ResponseEntity<ForecastResponse> getForecast(@RequestParam String city, @RequestParam(defaultValue = "en") String lang) {
        ForecastResponse response = weatherService.getForecast(city, lang);
        if (!"200".equals(response.getCod())) {
            return new ResponseEntity<>(response, HttpStatus.valueOf(Integer.parseInt(response.getCod())));
        }
        return ResponseEntity.ok(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
