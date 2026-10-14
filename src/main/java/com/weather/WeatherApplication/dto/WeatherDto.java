package com.weather.WeatherApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class WeatherDto {

    private Integer id;
    private String main;
    private String description;
    private String icon;
}
