package com.example.youtube.stockservice.assembler;

import com.example.youtube.stockservice.dto.SearchResponseDto;
import com.example.youtube.stockservice.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@Slf4j
public class SearchResponseAssembler {
    public SearchResponseDto toResource(List<User> users){
        return SearchResponseDto
                .builder()
                .users(users)
                .checkDate(LocalDateTime.now())
                .build();
    }
}
