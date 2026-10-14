package com.weather.WeatherApplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="weather")
public class GeneralWeather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "city")
    private String city;

    @Column(name = "description")
    private String description;

    @Column(name = "date")
    private String date;

    public GeneralWeather(String city, String description, String date) {
        this.city = city;
        this.description = description;
        this.date = date;
    }

    public GeneralWeather() {

    }

    @Override
    public String toString() {
        return "GeneralWeather{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
