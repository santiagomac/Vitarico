package com.example.Vitarico.infraestructure.utility;


import com.example.Vitarico.domain.entities.Customer;
import com.example.Vitarico.domain.models.customer.CustomerDto;

public class CustomerMapper {

    public static Customer toEntity(CustomerDto customerDto){
        return Customer.builder()
            .name(customerDto.getName())
            .lastname(customerDto.getLastname())
            .email(customerDto.getEmail())
            .document(customerDto.getDocument())
            .build();
    }
}
