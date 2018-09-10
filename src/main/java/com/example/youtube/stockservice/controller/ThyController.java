package com.example.youtube.stockservice.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ThyController.END_POINT)
public class ThyController {
    static final String END_POINT = "/thy";

    @GetMapping(value = "/deneme", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deneme(){
        return "THY deneme";
    }
}
