package com.example.Vitarico.infraestructure.utility;

import com.example.Vitarico.domain.dto.SalesDetailDto;
import com.example.Vitarico.domain.entities.Sales;
import com.example.Vitarico.domain.dto.SalesDto;
import com.example.Vitarico.domain.entities.SalesDetail;

import java.util.List;
import java.util.stream.Collectors;

public class SalesMapper {

    public static Sales toEntity(SalesDto salesDto) {
        return Sales.builder()
                .date(salesDto.getDate())
                .customerId(salesDto.getCustomerId())
                .description(salesDto.getDescription())
                .build();
    }

    public static SalesDto toDto(Sales sale) {
        return SalesDto.builder()
                .id(sale.getId())
                .description(sale.getDescription())
                .customerId(sale.getCustomerId())
                .date(sale.getDate())
                .build();
    }

    public static SalesDto toDto(Sales sale, List<SalesDetail> salesDetails) {
        return SalesDto.builder()
                .id(sale.getId())
                .description(sale.getDescription())
                .date(sale.getDate())
                .salesDetailDto(toDto(salesDetails))
                .build();
    }

    public static List<SalesDetail> toEntity(List<SalesDetailDto> salesDetailDto, Long saleId) {
         return salesDetailDto.stream().map(saleDetail -> SalesDetail.builder()
                 .productId(saleDetail.getProductId())
                 .saleId(saleId)
                 .amountProduct(saleDetail.getAmountProduct()).build()).collect(Collectors.toList());
    }

    public static List<SalesDetailDto> toDto(List<SalesDetail> salesDetail) {
        return salesDetail.stream().map(saleDetail -> SalesDetailDto.builder()
                .productId(saleDetail.getProductId())
                .amountProduct(saleDetail.getAmountProduct())
                .amountProduct(saleDetail.getAmountProduct()).build()).collect(Collectors.toList());
    }
}
