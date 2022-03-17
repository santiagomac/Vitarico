package com.example.Vitarico.controller;

import com.example.Vitarico.domain.entities.Customer;
import com.example.Vitarico.domain.models.customer.CustomerDto;
import com.example.Vitarico.domain.services.interfaces.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return this.customerService.getAllCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id){
        return this.customerService.getCustomer(id);
    }

    @PostMapping("/save")
    public Customer saveCustomer(@RequestBody CustomerDto customerDto){
        return this.customerService.saveCustomer(customerDto);
    }

    @PutMapping("/update/{id}")
    public Customer updateCustomer(@PathVariable Long id, @RequestBody CustomerDto customerDto){
        return this.customerService.updateCustomer(id, customerDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable Long id){
        this.customerService.deleteCustomer(id);
    }
}
