package com.Resilience.TimeOut.controller;

import com.Resilience.TimeOut.service.WeatherService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("api/v1/weather")
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    //time out
//    @GetMapping("/forecast")
//    public CompletableFuture<String> getForecast() {
//        return weatherService.getForecast();
//    }

    // retry

//        @GetMapping()
//    public String getForecast(@RequestParam String city) {
//        return weatherService.getWeather(city);
//    }


//    @GetMapping("/moreweather")
//    public String getMoreWeather(@RequestParam String city) {
//        return weatherService.getMoreWeather(city);
//    }


    @GetMapping()
    @CircuitBreaker(name = "getWeatherCircuitbreaker",fallbackMethod = "weatherFallback")
    public String getForecast(@RequestParam String city) {
        return weatherService.getWeather(city);
    }
    public String weatherFallback(String city, Throwable throwable) {
        return String.format("Weather service is currently unavailable for %s. Please try again later.", city);
    }
}
