package org.ghuh.ctcd.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dtetu
 */
@RestController
public class controller {

    @RequestMapping("/")
    public String helloWorld() {
        return "Hello World!";
    }

    @RequestMapping("/_health")
    @ResponseBody
    public ResponseEntity healthCheck() {
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
