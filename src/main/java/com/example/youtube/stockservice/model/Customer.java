package com.example.youtube.stockservice.model;

import lombok.*;
import lombok.experimental.Builder;
import org.springframework.hateoas.ResourceSupport;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer extends ResourceSupport {
    private String customerId;
    private String customerName;
    private String companyName;
    private School school;

    public Customer(String customerId, String customerName, String companyName) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.companyName = companyName;
    }
}
