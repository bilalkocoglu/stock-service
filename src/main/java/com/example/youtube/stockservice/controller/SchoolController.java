package com.example.youtube.stockservice.controller;

import com.example.youtube.stockservice.model.School;
import com.example.youtube.stockservice.service.CustomerService;
import com.example.youtube.stockservice.service.SchoolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/school")
public class SchoolController {

    private SchoolService schoolService;
    private CustomerService customerService;

    public SchoolController(SchoolService schoolService,
                            CustomerService customerService){
        this.schoolService = schoolService;
        this.customerService = customerService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Resources> getSchools(){
        Resources<School> schoolResource = schoolService.getAllSchool();

        if (schoolResource == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok().body(schoolResource);
    }

}
