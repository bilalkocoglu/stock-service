package com.example.youtube.stockservice.assembler;

import com.example.youtube.stockservice.controller.UserController;
import com.example.youtube.stockservice.model.Customer;
import com.example.youtube.stockservice.model.User;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class UserResourceAssembler implements ResourceAssembler<User, Resource<User>> {

    @Override
    public Resource<User> toResource(User user) {
        user.removeLinks();

        Link allUsers = linkTo(UserController.class).withRel("all users");
        Link detail = linkTo(UserController.class).slash(user.getId()).withRel("detail");

        return new Resource<>(user,detail,allUsers);
    }
}
