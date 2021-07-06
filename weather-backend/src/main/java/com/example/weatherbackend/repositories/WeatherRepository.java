package com.example.weatherbackend.repositories;

import com.example.weatherbackend.models.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {
    @Query("SELECT w FROM Weather w WHERE w.date BETWEEN :startDate and :endDate")
    List<Weather> findWeatherBetweenDate(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
