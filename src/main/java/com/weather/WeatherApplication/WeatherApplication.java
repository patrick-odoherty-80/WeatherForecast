package com.weather.WeatherApplication;

import com.weather.WeatherApplication.dao.GeneralWeatherDAO;
import com.weather.WeatherApplication.entity.GeneralWeather;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class WeatherApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(GeneralWeatherDAO generalWeatherDAO) {
		return runner -> {
			//createWeather(generalWeatherDAO);

			//readWeather(generalWeatherDAO);

			//queryForWeather(generalWeatherDAO);
		};
	}

	private void queryForWeather(GeneralWeatherDAO generalWeatherDAO) {
		List<GeneralWeather> theWeatherList = generalWeatherDAO.findAll();

		for (GeneralWeather theWeather : theWeatherList) {
			System.out.println(theWeather);
		}
	}

	private void readWeather(GeneralWeatherDAO generalWeatherDAO) {
		GeneralWeather tempWeather = new GeneralWeather("Chicago", "windy", "03/27/24");
		generalWeatherDAO.save(tempWeather);

		int theId = tempWeather.getId();

		GeneralWeather newWeather = generalWeatherDAO.findById(theId);

		System.out.println(newWeather);
	}

	private void createWeather(GeneralWeatherDAO generalWeatherDAO) {
		GeneralWeather tempWeather = new GeneralWeather("Cleveland", "rainy", "03/26/24");

		generalWeatherDAO.save(tempWeather);

		System.out.println("Saved weather city: " + tempWeather.getCity());
	}

}
