package com.example.Vitarico.infraestructure.utility;

import com.example.Vitarico.domain.entities.Sales;
import com.example.Vitarico.domain.models.sales.SalesDto;

public class SalesMapper {

    public static Sales toEntity(SalesDto salesDto){
        return Sales.builder()
            .date(salesDto.getDate())
            .description(salesDto.getDescription())
            .customer_id(salesDto.getCustomerId())
            .build();
    }
}
