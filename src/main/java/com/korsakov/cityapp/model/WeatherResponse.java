package com.korsakov.cityapp.model;

import lombok.Data;

@Data
public class WeatherResponse {
    private int cod;
    private String name;
    private Main main;
    private Wind wind;
    private Weather[] weather;
    private Clouds clouds;
    private int visibility;

    @Data
    public static class Main {
        private double temp;
        private int pressure;
        private int humidity;
    }

    @Data
    public static class Wind {
        private double speed;
    }

    @Data
    public static class Weather {
        private String description;
    }

    @Data
    public static class Clouds {
        private int all;
    }
}
