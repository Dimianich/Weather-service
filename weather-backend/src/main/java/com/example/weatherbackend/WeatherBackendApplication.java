package com.example.weatherbackend;

import com.example.weatherbackend.models.Weather;
import com.example.weatherbackend.repositories.WeatherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class WeatherBackendApplication {

	private static final Logger log = LoggerFactory.getLogger(WeatherBackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(WeatherBackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(WeatherRepository repository) {
		return (args) -> {
			// save a few weather
			if(repository.findAll().isEmpty()) {
				repository.save(new Weather(5, 740, 40, LocalDate.of(2021, 01, 15)));
				repository.save(new Weather(8, 750, 65, LocalDate.of(2021, 02, 20)));
				repository.save(new Weather(15, 765, 80, LocalDate.of(2021, 03, 18)));
				repository.save(new Weather(18, 755, 90, LocalDate.of(2021, 04, 10)));
				repository.save(new Weather(21, 770, 50, LocalDate.of(2021, 05, 9)));
				log.info("Weather create in db...");
			}
		};
	}

}
