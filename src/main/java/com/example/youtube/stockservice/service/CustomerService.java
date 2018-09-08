package com.example.youtube.stockservice.service;

import com.example.youtube.stockservice.assembler.CustomersResourceAssembler;
import com.example.youtube.stockservice.controller.CustomerController;
import com.example.youtube.stockservice.controller.SchoolController;
import com.example.youtube.stockservice.model.Customer;
import com.example.youtube.stockservice.model.School;
import com.example.youtube.stockservice.util.CustomerUtil;
import com.example.youtube.stockservice.util.SchoolUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Slf4j
@Service
public class CustomerService {

    private CustomersResourceAssembler customersResourceAssembler;

    public CustomerService(CustomersResourceAssembler customersResourceAssembler) {
        this.customersResourceAssembler = customersResourceAssembler;
    }

    public Resource<Customer> getCustomer(String id){
        log.info("GetCustomerById");
        List<Customer> customerList = CustomerUtil.customerList;
        Iterator<Customer> customerIterator = customerList.iterator();
        while (customerIterator.hasNext()){
            Customer customer = customerIterator.next();
            if (customer.getCustomerId().equals(id)){
                return customersResourceAssembler.toResource(customer);
            }
        }
        return null;
    }

    public Resources<Customer> getAllCustomers(){
        List<Customer> customerList = CustomerUtil.customerList;

        if (customerList == null)
            return null;

        return customersResourceAssembler.toResource(customerList);

    }

    public Resources<Customer> schoolToCustomer(){
        List<Customer> customerList = CustomerUtil.customerList;
        List<School> schoolList = Arrays.asList(SchoolUtil.schoolList);

        Random rnd = new Random();

        Iterator<Customer> customerIterator = customerList.iterator();
        while (customerIterator.hasNext()){
            Customer customer = customerIterator.next();

            School school =  schoolList.get( rnd.nextInt(schoolList.size()-1));

            school.removeLinks();

            school.add(linkTo(SchoolController.class).slash(school.getSchoolId()).withRel("datil"));
            school.add(linkTo(SchoolController.class).withRel("all school"));

            customer.setSchool(school);
        }

        Link self = linkTo(methodOn(CustomerController.class).getCustomerById("1")).withSelfRel();

        return new Resources<Customer>(customerList, self);
    }
}
