package com.example.Vitarico.domain.services.impl;

import com.example.Vitarico.domain.entities.Customer;
import com.example.Vitarico.domain.enums.ExceptionResponse;
import com.example.Vitarico.domain.models.customer.CustomerDto;
import com.example.Vitarico.domain.repository.CustomerRepository;
import com.example.Vitarico.domain.services.interfaces.CustomerService;
import com.example.Vitarico.exception.CustomerException;
import com.example.Vitarico.infraestructure.utility.CustomerMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
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
        if (customer.isEmpty()) {
            throw new RuntimeException("El cliente con el id seleccionado no existe");
        }
        return customer.get();
    }

    @Override
    public Customer saveCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.toEntity(customerDto);
        try {
            return this.customerRepository.save(customer);
        }catch (Exception e){
            log.error("Error al guardar el cliente");
            throw new CustomerException(ExceptionResponse.SAVE_ERROR.getMessage());
        }
    }

    @Override
    public void updateCustomer(Long id, CustomerDto customerDto) {
        Optional<Customer> customerToUpdate = this.customerRepository.findById(id);
        if (customerToUpdate.isEmpty()) {
            throw new CustomerException(String.format(ExceptionResponse.NOT_FOUND.getMessage(), id));
        }

        Customer customer = Customer.builder()
            .id(customerToUpdate.get().getId())
            .name(customerDto.getName())
            .lastname(customerDto.getLastname())
            .email(customerDto.getEmail())
            .document(customerDto.getDocument())
            .build();
        this.customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        boolean clientExists = this.customerRepository.findById(id).isEmpty();
        if (clientExists) {
            throw new CustomerException(String.format(ExceptionResponse.NOT_FOUND.getMessage(), id));
        }

        this.customerRepository.deleteById(id);
    }
}
