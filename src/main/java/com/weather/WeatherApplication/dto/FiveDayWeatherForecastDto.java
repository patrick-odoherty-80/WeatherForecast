package com.weather.WeatherApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class FiveDayWeatherForecastDto {

    private String cod;
    private Integer message;
    private Integer cnt;
    private List<FiveDayListDto> list;

    @AllArgsConstructor
    @Getter@Setter
    public static class FiveDayListDto {
        private Integer dt;
        private MainDto main;
        private List<WeatherDto> weather;
    }
}
