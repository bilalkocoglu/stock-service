package com.example.youtube.stockservice.controller;

import com.example.youtube.stockservice.dto.FeignExampleDto;
import com.example.youtube.stockservice.dto.SearchResponseDto;
import com.example.youtube.stockservice.dto.UserRequestDto;
import com.example.youtube.stockservice.dto.UserResponseDto;
import com.example.youtube.stockservice.model.User;
import com.example.youtube.stockservice.service.UserSearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = UserController.ENDPOINT)
public class UserController {
    static final String ENDPOINT = "/user";

    private UserSearchService userSearchService;

    public UserController(UserSearchService userSearchService) {
        this.userSearchService = userSearchService;
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseDto> getUser(@RequestBody UserRequestDto userRequestDto) throws Exception {
        log.info("User controller execute");
        UserResponseDto userResponseDto = userSearchService.searchUser(userRequestDto);
        if (userRequestDto!=null)
            return ResponseEntity.ok(userResponseDto);
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/search/{username}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SearchResponseDto> searchByUsername(@PathVariable("username") final String username){
        log.info("User Search Execute");
        SearchResponseDto searchResponseDto = userSearchService.searchUser(username);
        return ResponseEntity.ok(searchResponseDto);
    }

    @GetMapping(value = "/{userId}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Resource<User>> findById(@PathVariable("userId") final int userId){
        log.info("User find by id execute");
        Resource<User> userResource = userSearchService.searchUser(userId);
        if (userResource==null)
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok().body(userResource);

    }

    @GetMapping(value = "/deneme")
    public ResponseEntity deneme(){
        User user = new User();
        user.setUserId(1);
        user.setName("Bilal");
        user.setPassword("Muzo");
        return ResponseEntity.notFound().build();
}
}
