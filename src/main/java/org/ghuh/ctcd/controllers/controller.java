package org.ghuh.ctcd.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    @RequestMapping("/")
    public String helloWorld() {
        return "Hello World!";
    }
}
