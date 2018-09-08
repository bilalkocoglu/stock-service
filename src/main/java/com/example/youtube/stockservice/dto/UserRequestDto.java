package com.example.youtube.stockservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserRequestDto {
    private String username;
    private String password;
}
