package com.example.youtube.stockservice.assembler;

import com.example.youtube.stockservice.controller.CustomerController;
import com.example.youtube.stockservice.model.Customer;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.hateoas.Resources;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Component
public class CustomersResourceAssembler implements ResourceAssembler<List<Customer>, Resources<Customer>> {

    @Override
    public Resources<Customer> toResource(List<Customer> customers) {
        Iterator<Customer> customerIterator = customers.iterator();
        while (customerIterator.hasNext()){
            Customer customer = customerIterator.next();
            customer.removeLinks();
            customer.add( linkTo(CustomerController.class).slash(customer.getCustomerId()).withRel("detail"));
        }

        Link self = linkTo(methodOn(CustomerController.class).getCustomerById("1")).withSelfRel();

        return new Resources<Customer>(customers,self);
    }


    public Resource<Customer> toResource(Customer customer) {
        customer.removeLinks();

        Link allcustomer = linkTo(methodOn(CustomerController.class).getCustomerById(customer.getCustomerId())).withRel("allCustomer");

        Link self = linkTo(CustomerController.class).slash(customer.getCustomerId()).withSelfRel();

        return new Resource<Customer>(customer,self,allcustomer);
    }
}
