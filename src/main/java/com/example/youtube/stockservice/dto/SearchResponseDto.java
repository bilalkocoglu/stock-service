package com.example.youtube.stockservice.dto;

import com.example.youtube.stockservice.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SearchResponseDto {
    private List<User> users;

    private LocalDateTime checkDate;
}
