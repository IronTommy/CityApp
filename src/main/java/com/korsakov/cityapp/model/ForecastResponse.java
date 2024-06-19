package com.korsakov.cityapp.model;

import lombok.Data;
import java.util.List;

@Data
public class ForecastResponse {
    private String cod;
    private String message;
    private int cnt;
    private List<Forecast> list;

    @Data
    public static class Forecast {
        private Main main;
        private List<Weather> weather;
        private String dt_txt;

        @Data
        public static class Main {
            private double temp;
        }

        @Data
        public static class Weather {
            private String description;
        }
    }
}
