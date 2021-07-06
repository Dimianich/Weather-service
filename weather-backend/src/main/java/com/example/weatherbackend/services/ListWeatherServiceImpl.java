package com.example.weatherbackend.services;

import com.example.weatherbackend.models.Weather;
import com.example.weatherbackend.repositories.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ListWeatherServiceImpl implements ListWeatherService {
    @Autowired
    private WeatherRepository weatherRepository;

    @Override
    public List<Weather> getWeather(LocalDate startDate, LocalDate endDate) {
        return weatherRepository.findWeatherBetweenDate(startDate, endDate);
    }
}
