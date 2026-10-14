package com.weather.WeatherApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class SysDto {

    private Integer type;
    private Integer id;
    private String country;
    private Integer sunrise;
    private Integer sunset;
}
