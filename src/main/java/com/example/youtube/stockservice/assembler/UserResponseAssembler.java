package com.example.youtube.stockservice.assembler;

import com.example.youtube.stockservice.dto.UserResponseDto;
import com.example.youtube.stockservice.model.User;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class UserResponseAssembler {
    public UserResponseDto toUserDto(Resource<User> userResource){
        User user = userResource.getContent();
        return UserResponseDto
                .builder()
                .id(user.getUserId())
                .username(user.getName())
                .password(user.getPassword())
                .checkDate(LocalDateTime.now())
                .build();
    }
}
