package com.example.youtube.stockservice.util;

import com.example.youtube.stockservice.model.Customer;

import java.util.Arrays;
import java.util.List;


public class CustomerUtil {
    public static List<Customer> customerList = Arrays.asList(new Customer[]{
            new Customer("1" , "bilal" , "koçoğlu"  ),
            new Customer("2" , "onur"  , "koçoğlu"  ),
            new Customer("3" , "betul" , "altay"    ),
            new Customer("4" , "kayra" , "altay"    )});
}
