package com.example.Vitarico.domain.services.impl;

import com.example.Vitarico.domain.entities.Customer;
import com.example.Vitarico.domain.models.customer.CustomerDto;
import com.example.Vitarico.domain.repository.CustomerRepository;
import com.example.Vitarico.domain.services.interfaces.CustomerService;
import com.example.Vitarico.infraestructure.utility.CustomerMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
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
    public Customer getCustomer(Long id) {
        Optional<Customer> customer = this.customerRepository.findById(id);
        if(customer.isEmpty()) {
            throw new RuntimeException("El cliente con el id seleccionado no existe");
        }
        return customer.get();
    }

    @Override
    public Customer saveCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.toEntity(customerDto);
        return this.customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, CustomerDto customerDto) {
        Optional<Customer> customerToUpdate = this.customerRepository.findById(id);
        if (!customerToUpdate.isEmpty()){
            Customer customer = Customer.builder()
                    .id(customerToUpdate.get().getId())
                    .name(customerDto.getName())
                    .lastname(customerDto.getLastname())
                    .email(customerDto.getEmail())
                    .document(customerDto.getDocument())
                    .build();
            return this.customerRepository.save(customer);
        }

        throw new RuntimeException("El cliente con el ID seleccionado no existe");
    }

    @Override
    public void deleteCustomer(Long id) {
        this.customerRepository.deleteById(id);
    }
}
