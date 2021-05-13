package com.example.demo.controller;

import com.example.demo.model.CurrentWeather;
import com.example.demo.service.LiveWeatherService;
import com.example.demo.service.StubWeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;

@Controller
public class CurrentWeatherController {

    private final StubWeatherService stubWeatherService;
    private final LiveWeatherService liveWeatherService;

    public CurrentWeatherController(StubWeatherService stubWeatherService, LiveWeatherService liveWeatherService) {
        this.stubWeatherService = stubWeatherService;
        this.liveWeatherService = liveWeatherService;
    }

    @GetMapping("/current-weather")
    public String getCurrentWeather(Model model) {
        if (true) {
            model.addAttribute("currentWeather", liveWeatherService.getCurrentWeather("Detroit","us"));
        } else {
            model.addAttribute("currentWeather", stubWeatherService.getCurrentWeather("Detroit","us"));
        }
        return "current-weather";
    }
}