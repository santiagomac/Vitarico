package com.example.Vitarico.controller;

import com.example.Vitarico.domain.entities.Customer;
import com.example.Vitarico.domain.services.interfaces.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public String getCustomer(){
        return "This is a get method that return the customer";
    }

    @PostMapping("/save")
    public Customer saveCustomer(@RequestBody Customer customerToSave){
        return this.customerService.saveCustomer(customerToSave);
    }
}
