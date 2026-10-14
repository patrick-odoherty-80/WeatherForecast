package com.weather.WeatherApplication.dao;

import com.weather.WeatherApplication.entity.GeneralWeather;

import java.util.List;

public interface GeneralWeatherDAO {

    void save(GeneralWeather generalWeather);

    GeneralWeather findById(Integer id);

    List<GeneralWeather> findAll();

    void deleteById(int theId);
}
