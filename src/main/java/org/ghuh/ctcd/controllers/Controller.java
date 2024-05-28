package org.ghuh.ctcd.controllers;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dtetu
 */
@RestController
public class Controller {

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
    public ArrayList<HashMap<String, String>> getCity() {
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        map.put("name", "Hanoi");
        map.put("population", "8,000,000");
        list.add(map);
        map = new HashMap<>();
        map.put("name", "HCMC");
        map.put("population", "10,000,000");
        list.add(map);
        return list;
    }
}
