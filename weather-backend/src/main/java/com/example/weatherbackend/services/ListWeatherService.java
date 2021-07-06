package com.example.weatherbackend.services;

import com.example.weatherbackend.models.Weather;

import java.time.LocalDate;
import java.util.List;

public interface ListWeatherService {
    List<Weather> getWeather(LocalDate startDate, LocalDate endDate);
}
