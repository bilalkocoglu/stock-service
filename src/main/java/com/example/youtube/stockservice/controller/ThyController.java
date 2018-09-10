package com.example.youtube.stockservice.controller;

import com.example.youtube.stockservice.dto.CalculateAwardMilesWithTaxRequestDto;
import com.example.youtube.stockservice.model.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = ThyController.END_POINT)
public class ThyController {
    static final String END_POINT = "/thy";

    private RestTemplate restTemplate;

    public ThyController(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/deneme", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity deneme(){
        User user = new User();
        user.setUserId(2);
        user.setName("THY");
        user.setPassword("API");
        return ResponseEntity.ok().body(user);
    }

    @GetMapping(value = "/calculateAward", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity calculateAward(){
        CalculateAwardMilesWithTaxRequestDto camwtq =
                new CalculateAwardMilesWithTaxRequestDto("E","F","T","IST","FRA",12,11,2017);

        return ResponseEntity.notFound().build();
    }
}
