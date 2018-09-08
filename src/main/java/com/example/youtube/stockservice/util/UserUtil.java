package com.example.youtube.stockservice.util;

import com.example.youtube.stockservice.model.User;

import java.util.Arrays;
import java.util.List;

public class UserUtil {
    public static List<User> users = Arrays.asList(new User[]{
            new User(1,"bilal" , "123"),
            new User(2,"onur"  , "123"),
            new User(3,"betül" , "123"),
            new User(4,"kayra" , "123"),
            new User(5,"nergis", "123"),
            new User(6,"kenan" , "123"),
            new User(7,"kayra" , "456"),
            new User(8,"nergis", "456"),
            new User(9,"kenan" , "456"),
            new User(10,"kayra" , "234"),
            new User(11,"nergis", "234"),
            new User(12,"kenan" , "234"),
    });
}
