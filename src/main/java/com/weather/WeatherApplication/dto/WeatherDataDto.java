package com.weather.WeatherApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class WeatherDataDto {

    private CoordinateDto coord;
    private List<WeatherDto> weather;
    private String base;
    private MainDto main;
    private Integer visibility;
    private WindDto wind;
    //private RainDto rain;
    //private CloudsDto clouds;
    private Integer dt;
    private SysDto sys;
    private Integer id;
    private String name;
    private Integer cod;

    public WeatherDataDto() {

    }


    @AllArgsConstructor
    @Getter@Setter
    public static class CoordinateDto {
        private BigDecimal lon;
        private BigDecimal lat;
    }

    @AllArgsConstructor
    @Getter@Setter
    public static class RainDto {
        private BigDecimal one_hour;
    }

    @AllArgsConstructor
    @Getter@Setter
    public static class CloudsDto {
        private Integer all;
    }
}
