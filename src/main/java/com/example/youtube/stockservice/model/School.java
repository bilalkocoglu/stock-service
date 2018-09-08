package com.example.youtube.stockservice.model;

import lombok.*;
import lombok.experimental.Builder;
import org.springframework.hateoas.ResourceSupport;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class School extends ResourceSupport {

    private int schoolId;

    private String name;

    private String city;

}


