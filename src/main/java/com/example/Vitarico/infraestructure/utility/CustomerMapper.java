package com.example.Vitarico.infraestructure.utility;


import com.example.Vitarico.domain.entities.Customer;
import com.example.Vitarico.domain.dto.CustomerDto;

public class CustomerMapper {

    private CustomerMapper(){
        throw new IllegalStateException("Utility class");
    }

    public static Customer toEntity(CustomerDto customerDto) {
        return Customer.builder()
                .name(customerDto.getName())
                .lastname(customerDto.getLastname())
                .email(customerDto.getEmail())
                .document(customerDto.getDocument())
                .build();
    }

    public static CustomerDto toDto(Customer customer){
        return CustomerDto.builder()
                .name(customer.getName())
                .lastname(customer.getLastname())
                .document(customer.getDocument())
                .email(customer.getEmail())
                .build();
    }
}
