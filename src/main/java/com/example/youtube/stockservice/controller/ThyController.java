package com.example.youtube.stockservice.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.LogManager;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = this.END_POINT)
public class ThyController {
    static final String END_POINT = "/thy";

    private static final Logger log = (Logger) org.apache.logging.log4j.LogManager.getLogger(UserController.class);

    @GetMapping(value = "/deneme", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deneme(){
        return "THY deneme";
    }
}
