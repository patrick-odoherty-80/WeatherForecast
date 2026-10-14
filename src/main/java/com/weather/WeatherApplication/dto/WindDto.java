package com.weather.WeatherApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class WindDto {

    private BigDecimal speed;
    private Integer deg;
    private BigDecimal gust;
}
