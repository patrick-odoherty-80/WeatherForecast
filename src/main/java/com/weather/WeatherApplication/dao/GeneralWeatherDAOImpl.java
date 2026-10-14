package com.weather.WeatherApplication.dao;

import com.weather.WeatherApplication.entity.GeneralWeather;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class GeneralWeatherDAOImpl implements GeneralWeatherDAO {

    private EntityManager entityManager;

    @Autowired
    public GeneralWeatherDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(GeneralWeather generalWeather){
        entityManager.persist(generalWeather);
    }


    @Override
    public GeneralWeather findById(Integer id) {
        return entityManager.find(GeneralWeather.class, id);
    }

    @Override
    public List<GeneralWeather> findAll() {
        TypedQuery<GeneralWeather> theQuery = entityManager.createQuery("FROM GeneralWeather", GeneralWeather.class);

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        GeneralWeather generalWeather = entityManager.find(GeneralWeather.class, theId);

        entityManager.remove(generalWeather);
    }
}
