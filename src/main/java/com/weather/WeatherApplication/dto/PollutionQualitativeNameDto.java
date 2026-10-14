package com.weather.WeatherApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PollutionQualitativeNameDto {

    private String sulfurDioxide;
    private String carbonMonoxide;
    private String nitrogenDioxide;
    private String ozone;
    private String particulatesTwoFive;
    private String particulatesTen;
}
