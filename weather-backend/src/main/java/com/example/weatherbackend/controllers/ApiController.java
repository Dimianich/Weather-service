package com.example.weatherbackend.controllers;

import com.example.weatherbackend.models.Weather;
import com.example.weatherbackend.services.ListWeatherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
public class ApiController {
    @Autowired
    private ListWeatherServiceImpl listWeatherService;

    @GetMapping(value = "/api/weather")
    public ResponseEntity<List<Weather>> getWeather(@RequestParam(value = "startDate")
                                                        @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate startDate,
                                                    @RequestParam(value = "endDate")
                                                    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate endDate) {



        final List<Weather> weatherList = listWeatherService.getWeather(startDate, endDate);

        return (weatherList != null && !weatherList.isEmpty())
                ? new ResponseEntity<>(weatherList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
