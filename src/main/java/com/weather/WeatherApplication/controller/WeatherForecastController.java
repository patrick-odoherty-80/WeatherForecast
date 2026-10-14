package com.weather.WeatherApplication.controller;

import com.weather.WeatherApplication.dao.GeneralWeatherDAOImpl;
import com.weather.WeatherApplication.dto.*;
import com.weather.WeatherApplication.entity.GeneralWeather;
import com.weather.WeatherApplication.service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;


@Controller
public class WeatherForecastController {

    private final WeatherService weatherService;

    private final GeneralWeatherDAOImpl generalWeatherDAO;

    public WeatherForecastController(WeatherService weatherService, GeneralWeatherDAOImpl generalWeatherDAO) {
        this.weatherService = weatherService;
        this.generalWeatherDAO = generalWeatherDAO;
    }


    @GetMapping("/city")
    public String showWeather(Model theModel){

        return "search-city";
    }

    @GetMapping("/list")
    public String listWeatherResults(Model theModel){
        List<GeneralWeather> generalWeatherList = generalWeatherDAO.findAll();

        theModel.addAttribute("generalWeatherList", generalWeatherList);

        return "weather-results-list";
    }

    @GetMapping("/delete")
    public String deleteWeatherResult(@RequestParam("weatherId") int weatherId) {
        /*GeneralWeather generalWeatherResult = generalWeatherDAO.findById(weatherId);

        if (generalWeatherResult == null) {
            throw new RuntimeException("Weather result not found for " + weatherId);
        }*/

        generalWeatherDAO.deleteById(weatherId);

        return "redirect:/list";
    }


    @RequestMapping("/weather")
    public String getCurrentWeather(@RequestParam(value = "city", required = true) String city, Model theModel) throws ParseException {
        WeatherDataDto weather = weatherService.getCurrentWeather(city);

        String cityLat = weather.getCoord().getLat().toString();
        String cityLon = weather.getCoord().getLon().toString();

        PollutionDataDto pollution = weatherService.getPollution(cityLat, cityLon);
        FiveDayWeatherForecastDto fiveDayForecast = weatherService.getFiveDayForecast(cityLat, cityLon);

        LocalDate date = LocalDate.now();

        GeneralWeather generalWeather = new GeneralWeather(city, weather.getWeather().get(0).getDescription(), date.toString());
        generalWeatherDAO.save(generalWeather);


        Double sulfurDioxide = pollution.getList().get(0).getComponents().getSo2();
        Double carbonMonoxide = pollution.getList().get(0).getComponents().getCo();
        Double nitrogenDioxide = pollution.getList().get(0).getComponents().getNo2();
        Double ozone = pollution.getList().get(0).getComponents().getO3();
        Double particulatesTwoFive = pollution.getList().get(0).getComponents().getPm2_5();
        Double particulatesTen = pollution.getList().get(0).getComponents().getPm10();

        PollutionQualitativeNameDto pollutionRating = new PollutionQualitativeNameDto(
                soTwoLevels(sulfurDioxide),
                coLevels(carbonMonoxide),
                noTwoLevels(nitrogenDioxide),
                oThreeLevels(ozone),
                pmTwoFiveLevels(particulatesTwoFive),
                pmTenLevels(particulatesTen)
        );


        theModel.addAttribute("weather", weather);
        theModel.addAttribute("pollution", pollution);
        theModel.addAttribute("pollutionRating", pollutionRating);
        theModel.addAttribute("currentDate", date);
        theModel.addAttribute("fiveDayForecast", fiveDayForecast);
        theModel.addAttribute("generalWeather", generalWeather);

        return "process-weather";
    }


    public String soTwoLevels(Double pollutant) {
        String rating = null;
        if(0 <= pollutant && pollutant < 20){
            rating = "Good";
        } else if (20 <= pollutant && pollutant < 80) {
            rating = "Fair";
        } else if (80 <= pollutant && pollutant < 250){
            rating = "Moderate";
        } else if (250 <= pollutant && pollutant < 350) {
            rating = "Poor";
        }else if(350 <= pollutant){
            rating = "Very Poor";
        }
        return rating;
    }

    public String noTwoLevels(Double pollutant) {
        String rating = null;
        if(0 <= pollutant && pollutant < 40){
            rating = "Good";
        } else if (40 <= pollutant && pollutant < 70) {
            rating = "Fair";
        } else if (70 <= pollutant && pollutant < 150){
            rating = "Moderate";
        } else if (150 <= pollutant && pollutant < 200) {
            rating = "Poor";
        }else if(200 <= pollutant){
            rating = "Very Poor";
        }
        return rating;
    }

    public String pmTenLevels(Double pollutant) {
        String rating = null;
        if(0 <= pollutant && pollutant < 20){
            rating = "Good";
        } else if (20 <= pollutant && pollutant < 50) {
            rating = "Fair";
        } else if (50 <= pollutant && pollutant < 100){
            rating = "Moderate";
        } else if (100 <= pollutant && pollutant < 200) {
            rating = "Poor";
        }else if(200 <= pollutant){
            rating = "Very Poor";
        }
        return rating;
    }

    public String pmTwoFiveLevels(Double pollutant) {
        String rating = null;
        if(0 <= pollutant && pollutant < 10){
            rating = "Good";
        } else if (10 <= pollutant && pollutant < 25) {
            rating = "Fair";
        } else if (25 <= pollutant && pollutant < 50){
            rating = "Moderate";
        } else if (50 <= pollutant && pollutant < 75) {
            rating = "Poor";
        }else if(75 <= pollutant){
            rating = "Very Poor";
        }
        return rating;
    }

    public String oThreeLevels(Double pollutant) {
        String rating = null;
        if(0 <= pollutant && pollutant < 60){
            rating = "Good";
        } else if (60 <= pollutant && pollutant < 100) {
            rating = "Fair";
        } else if (100 <= pollutant && pollutant < 140){
            rating = "Moderate";
        } else if (140 <= pollutant && pollutant < 180) {
            rating = "Poor";
        }else if(180 <= pollutant){
            rating = "Very Poor";
        }
        return rating;
    }

    public String coLevels(Double pollutant) {
        String rating = null;
        if(0 <= pollutant && pollutant < 4400){
            rating = "Good";
        } else if (4400 <= pollutant && pollutant < 9400) {
            rating = "Fair";
        } else if (9400 <= pollutant && pollutant < 12400){
            rating = "Moderate";
        } else if (12400 <= pollutant && pollutant < 15400) {
            rating = "Poor";
        }else if(15400 <= pollutant){
            rating = "Very Poor";
        }
        return rating;
    }
}
