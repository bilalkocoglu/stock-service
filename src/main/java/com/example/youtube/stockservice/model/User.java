package com.example.youtube.stockservice.model;

import lombok.*;
import lombok.experimental.Builder;
import org.springframework.hateoas.ResourceSupport;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User extends ResourceSupport {

    private int userId;

    private String name;

    private String password;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
