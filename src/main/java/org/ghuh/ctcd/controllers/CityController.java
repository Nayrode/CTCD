package org.ghuh.ctcd.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.ghuh.ctcd.entities.City;
import org.ghuh.ctcd.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dtetu
 */
@RestController
public class CityController {
    private final CityService cityService;
    private static final Logger Logger = LogManager.getLogger(CityController.class);

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @RequestMapping("/")
    public String helloWorld() {
        return "Hello World!";
    }

    @SuppressWarnings("rawtypes")
    @RequestMapping("/_health")
    public ResponseEntity healthCheck() {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping("/city")
    public List<City> getCity() {
        return this.cityService.getAllCities();
    }

    @PostMapping("/city")
    public City saveCity(@RequestBody City city) {
        return this.cityService.save(city);
    }
}
