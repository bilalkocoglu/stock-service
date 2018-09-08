package com.example.youtube.stockservice.service;

import com.example.youtube.stockservice.assembler.SearchResponseAssembler;
import com.example.youtube.stockservice.assembler.UserResourceAssembler;
import com.example.youtube.stockservice.assembler.UserResponseAssembler;
import com.example.youtube.stockservice.dto.SearchResponseDto;
import com.example.youtube.stockservice.dto.UserRequestDto;
import com.example.youtube.stockservice.dto.UserResponseDto;
import com.example.youtube.stockservice.model.User;
import com.example.youtube.stockservice.util.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Slf4j
public class UserSearchService {

    private UserResponseAssembler userResponseAssembler;
    private SearchResponseAssembler searchResponseAssembler;
    private UserResourceAssembler userResourceAssembler;

    public UserSearchService(UserResponseAssembler userResponseAssembler,
                             SearchResponseAssembler searchResponseAssembler,
                             UserResourceAssembler userResourceAssembler) {
        this.userResponseAssembler = userResponseAssembler;
        this.searchResponseAssembler = searchResponseAssembler;
        this.userResourceAssembler = userResourceAssembler;
    }

    public UserResponseDto searchUser(UserRequestDto userRequestDto) throws Exception{
        List<User> users = UserUtil.users;
        Iterator<User> userIterator = users.iterator();

        while (userIterator.hasNext()){
            User user = userIterator.next();
            if (user.getName().equals(userRequestDto.getUsername()) && user.getPassword().equals(userRequestDto.getPassword())){
                Resource<User> userResource = userResourceAssembler.toResource(user);
                return userResponseAssembler.toUserDto(userResource);
            }
        }
        return null;
    }

    public SearchResponseDto searchUser(String username){
        List<User> users = UserUtil.users;
        Iterator<User> userIterator = users.iterator();
        List<User> result = new ArrayList<>();

        while (userIterator.hasNext()){
            User user = userIterator.next();

            if (user.getName().equals(username)){
                result.add(user);
            }
        }

        return searchResponseAssembler.toResource(result);
    }

    public Resource<User> searchUser(int id){
        List<User> users = UserUtil.users;

        for (User user:users){
            if (user.getUserId() == id){
                return userResourceAssembler.toResource(user);
            }
        }
        return null;
    }
}
