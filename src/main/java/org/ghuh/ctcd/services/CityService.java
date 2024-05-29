package org.ghuh.ctcd.services;

import java.util.List;

import org.ghuh.ctcd.entities.City;
import org.ghuh.ctcd.interfaces.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    private final CityRepository cityRepository;
    
    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }
    
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public City save(City city) {
        return cityRepository.save(city);
    }
}
