package com.example.youtube.stockservice.model;

import lombok.*;
import lombok.experimental.Builder;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    private int id;

    private String name;

    private String password;

    private School school;

}
