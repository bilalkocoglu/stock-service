package com.example.youtube.stockservice.controller;

import com.example.youtube.stockservice.model.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ThyController.END_POINT)
public class ThyController {
    static final String END_POINT = "/thy";

    @GetMapping(value = "/deneme", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deneme(){
        User user = new User();
        user.setUserId(2);
        user.setName("THY");
        user.setPassword("API");
        return ResponseEntity.ok().body(user);
    }
}
