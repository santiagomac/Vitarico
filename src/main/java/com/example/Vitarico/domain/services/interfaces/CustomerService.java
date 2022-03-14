package com.example.Vitarico.domain.services.interfaces;

import com.example.Vitarico.domain.entities.Customer;
import com.example.Vitarico.domain.models.customer.CustomerDto;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public interface CustomerService {
    List<Customer> getAllCustomers();
    Optional<Customer> getCustomer(Long id);
    Customer saveCustomer(CustomerDto customerDto);
}
