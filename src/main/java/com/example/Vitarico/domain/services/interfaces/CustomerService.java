package com.example.Vitarico.domain.services.interfaces;

import com.example.Vitarico.domain.entities.Customer;
import com.example.Vitarico.domain.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomer(Long id);
    Customer saveCustomer(CustomerDto customerDto);
    void updateCustomer(Long id, CustomerDto customerDto);
    void deleteCustomer(Long id);
}
