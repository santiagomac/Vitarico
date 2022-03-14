package com.example.Vitarico.domain.services.impl;

import com.example.Vitarico.domain.entities.Customer;
import com.example.Vitarico.domain.models.customer.CustomerDto;
import com.example.Vitarico.domain.repository.CustomerRepository;
import com.example.Vitarico.domain.services.interfaces.CustomerService;
import com.example.Vitarico.infraestructure.utility.CustomerMapper;
import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomer(Long id) {
        return this.customerRepository.findById(id);
    }

    @Override
    public Customer saveCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.toEntity(customerDto);
        return this.customerRepository.save(customer);
    }
}
