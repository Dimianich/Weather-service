package com.example.weatherbackend.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="weather")
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private LocalDate date;
    private Integer temperature;
    private Integer pressure;
    private Integer humidity;

    public Weather() {}

    public Weather(Integer temperature, Integer pressure, Integer humidity, LocalDate date) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    public Integer getPressure() {
        return pressure;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", temperature='" + temperature + '\'' +
                ", pressure='" + pressure + '\'' +
                ", humidity='" + humidity + '\'' +
                '}';
    }
}
