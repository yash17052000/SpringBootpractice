package com.Resilience.TimeOut.client;


import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class WeatherClient {

    // TimeOut

//    @TimeLimiter(name = "weatherForeCastLimiter",fallbackMethod = "fallback")
//    public CompletableFuture<String> getForecast() {
//        return CompletableFuture.supplyAsync(() -> {
//             try {
//                Thread.sleep(1000); // Simulate slow API
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//            return "Success after delay";
//        });
//    }
//    public CompletableFuture<String> fallback(Throwable t) {
//        return CompletableFuture.completedFuture("Fallback response - " +
//                "Weather Forecast not available at the moment.");
//    }




    // Retry Mechanism


//    @Retry(name = "getWeatherRetry",fallbackMethod ="fallbackgetWeather")
//    public String getWeather(String city){
//        RestTemplate restTemplate= new RestTemplate();
//        log.info("Called this external api  with retry mechanism");
//        return restTemplate.getForObject("https://httpstat.us/500?sleep=1000",String.class);
//    }
//    public String fallbackgetWeather(Exception ex) {
//
//        return "Weather service is currently unavailable. Please try again later.";
//    }

//    @RateLimiter(name = "getRateLimiter",fallbackMethod = "getRateLimiterFallback")
//    public String getWeather(final String city) {
//        return String.format("Sunniy is %s", city);
//    }
//    @RateLimiter(name = "getMorWeathereRateLimiter",fallbackMethod = "getRateLimiterFallback")
//    public String getMoreWeather(final String city) {
//        return String.format("Sunniy is %s", city);
//    }
//
//        public String getRateLimiterFallback(Exception ex) {
//
//        return "Too Many requests try again later";
//    }

}
