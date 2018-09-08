package com.example.youtube.stockservice.controller;


import com.example.youtube.stockservice.model.Customer;
import com.example.youtube.stockservice.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.CookieGenerator;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Slf4j
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private CustomerService customerService;

    private CookieGenerator cookieGenerator = new CookieGenerator();

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Resource<Customer>> getCustomerById(@PathVariable String customerId) {
        Resource<Customer> customer = customerService.getCustomer(customerId);

        if (customer == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(customer);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Resources> getAllCustomer() {
        Resources<Customer> customers = customerService.getAllCustomers();

        if (customers == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(customers);
    }

    @GetMapping(value = "/custandschol", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Resources> getFullCustomer() {

        Resources<Customer> customers = customerService.schoolToCustomer();

        if (customers == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(customers);
    }

    @GetMapping(value = "/cookie", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addcookie(HttpServletResponse response){
        Cookie cookie = new Cookie("name", "bilal");
        cookie.setMaxAge(60*60);
        cookie.setDomain("example.com");
        cookie.setPath("/cookie");
        response.addCookie(cookie);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/cookie/read", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addcookie(HttpServletRequest request, HttpServletResponse response){
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.SET_COOKIE, "deneme=deneme");
        return ResponseEntity.ok().header("deneme=bilal").build();
    }

}
