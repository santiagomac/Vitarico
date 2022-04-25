package com.example.Vitarico.infraestructure.utility;

import com.example.Vitarico.domain.dto.ProductDto;
import com.example.Vitarico.domain.entities.Product;

public class ProductMapper {

    private ProductMapper(){
        throw new IllegalStateException("Utility class");
    }

    public static Product toEntity(ProductDto productDto){
        return Product.builder()
            .id(productDto.getId())
            .name(productDto.getName())
            .price(productDto.getPrice())
            .code(productDto.getCode())
            .stock(productDto.getStock()).build();
    }

    public static ProductDto toDto(Product product){
        return ProductDto.builder()
            .id(product.getId())
            .name(product.getName())
            .price(product.getPrice())
            .code(product.getCode())
            .stock(product.getStock()).build();
    }
}
