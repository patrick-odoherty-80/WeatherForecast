package com.weather.WeatherApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class PollutionDataDto {

    private Coordinate coord;
    private List<ListDto> list;

    @AllArgsConstructor
    @Getter@Setter
    public static class ComponentsDto {
        public Double co;
        public Double no;
        public Double no2;
        public Double o3;
        public Double so2;
        public Double pm2_5;
        public Double pm10;
        public Double nh3;
    }

    @AllArgsConstructor
    @Getter
    @Setter
    public static class ListDto {
        //private main main;
        public ComponentsDto components;
        public Integer dt;
    }

    @AllArgsConstructor
    @Getter
    @Setter
    public static class main{
        private Integer aqi;
    }

    @AllArgsConstructor
    @Getter@Setter
    public static class Coordinate {
        private BigDecimal lon;
        private BigDecimal lat;
    }
}
