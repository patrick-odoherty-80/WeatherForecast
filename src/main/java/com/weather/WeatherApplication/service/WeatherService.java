package com.weather.WeatherApplication.service;

import com.weather.WeatherApplication.dto.FiveDayWeatherForecastDto;
import com.weather.WeatherApplication.dto.PollutionDataDto;
import com.weather.WeatherApplication.dto.WeatherDataDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WeatherService {

    private final String url = "https://api.openweathermap.org/data/2.5/weather?q=Cleveland&units=imperial&appid=cf1adfda5d79a3c089e44e03af84c0aa";

    @Autowired
    private WebClient.Builder builder;

    public WeatherDataDto getCurrentWeather(String city) {

        String uri = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=imperial&appid=cf1adfda5d79a3c089e44e03af84c0aa";

        WeatherDataDto weather = builder.build()
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(WeatherDataDto.class)
                .block();

        return weather;
    }

    public FiveDayWeatherForecastDto getFiveDayForecast(String lat, String lon) {
        String uri = "http://api.openweathermap.org/data/2.5/forecast?lat=" + lat + "&lon=" + lon + "&units=imperial&appid=cf1adfda5d79a3c089e44e03af84c0aa";
        FiveDayWeatherForecastDto fiveDayForecast = builder.build()
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(FiveDayWeatherForecastDto.class)
                .block();
        return fiveDayForecast;
    }

    public PollutionDataDto getPollution(String lat, String lon) {

        String uri = "http://api.openweathermap.org/data/2.5/air_pollution?lat=" + lat + "&lon=" + lon + "&appid=cf1adfda5d79a3c089e44e03af84c0aa";

        PollutionDataDto pollutionData = builder.build()
                .get()
                .uri(uri)
                .retrieve()
                .bodyToMono(PollutionDataDto.class)
                .block();

        return pollutionData;
    }
}
