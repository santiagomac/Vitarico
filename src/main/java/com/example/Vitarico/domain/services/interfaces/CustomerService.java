package com.example.Vitarico.domain.services.interfaces;

import com.example.Vitarico.domain.entities.Customer;
import com.example.Vitarico.domain.models.customer.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomer(Long id);
    Customer saveCustomer(CustomerDto customerDto);
    Customer updateCustomer(Long id, CustomerDto customerDto);
    void deleteCustomer(Long id);
}
