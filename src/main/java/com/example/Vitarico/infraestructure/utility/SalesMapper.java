package com.example.Vitarico.infraestructure.utility;

import com.example.Vitarico.domain.entities.Sales;
import com.example.Vitarico.domain.dto.SalesDto;

public class SalesMapper {

    public static Sales toEntity(SalesDto salesDto){
        return Sales.builder()
            .date(salesDto.getDate())
            .description(salesDto.getDescription())
            .customerId(salesDto.getCustomerId())
            .build();
    }

    public static SalesDto toDto(Sales sale){
        return SalesDto.builder()
                .customerId(sale.getCustomerId())
                .description(sale.getDescription())
                .date(sale.getDate())
                .build();
    }
}
