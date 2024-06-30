package org.ghuh.ctcd;

import org.ghuh.ctcd.controllers.CityController;
import org.ghuh.ctcd.entities.City;
import org.ghuh.ctcd.services.CityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/*un test qui s'assure que l'insertion dans la base de données fonctionne correctement ;
	un test qui s'assure que la récupération de la liste des villes fonctionne correctement ;
	un test qui s'assure que l'endpoint de healthcheck fonctionne correctement.*/
@SpringBootTest(classes = {CtcdApplication.class, CityController.class})
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class CityControllerTest {
    @Mock
    private CityService cityService;

    @InjectMocks
    private CityController cityController;

    @Test
    void testSaveCity() {
        City city = new City();
        city.setName("Test City");

        when(cityService.save(city)).thenReturn(city);

        ResponseEntity<City> response = cityController.saveCity(city);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(city, response.getBody());
    }

    @Test
    void testGetCity() {
        City city1 = new City();
        city1.setName("City1");
        City city2 = new City();
        city2.setName("City2");

        List<City> cityList = Arrays.asList(city1, city2);

        when(cityService.getAllCities()).thenReturn(cityList);

        List<City> result = cityController.getCity();

        assertEquals(2, result.size());
        assertEquals("City1", result.get(0).getName());
        assertEquals("City2", result.get(1).getName());
    }

    @Test
    void testHealthCheck() {
        ResponseEntity<?> response = cityController.healthCheck();

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}
