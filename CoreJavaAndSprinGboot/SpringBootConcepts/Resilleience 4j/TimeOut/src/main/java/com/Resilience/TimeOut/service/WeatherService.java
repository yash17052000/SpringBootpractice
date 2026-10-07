package com.Resilience.TimeOut.service;


import com.Resilience.TimeOut.client.WeatherClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;



@Service
public class WeatherService {

    private final WeatherClient weatherClient;

    public WeatherService(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }
//time out
//    public CompletableFuture<String> getForecast() {
//        return weatherClient.getWeather("Ghaziabad");
//    }

    // retry
//        public String getWeather(String city) {
//        return weatherClient.getWeather(city);
//    }


    // api rate limiter
//
//
//    public String getWeather(String city) {
//        return weatherClient.getWeather(city);
//    }
//
//    public String getMoreWeather(String city) {
//        return weatherClient.getWeather(city);
//    }


    public String getWeather(final String city) {
        // Simulate a call to a weather API
        if ("error".equalsIgnoreCase(city)) {
            throw new RuntimeException("Simulated API failure");
        } else if ("timeout".equalsIgnoreCase(city)) {
            try {
                Thread.sleep(3000); // Simulate a long-running operation
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            throw new RuntimeException("Simulated timeout");
        }
        return String.format("Sunny in %s", city);
    }
}
