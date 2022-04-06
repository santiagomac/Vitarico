package com.example.Vitarico.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public List<ProductDto> getProducts() {
        return this.productService.getProducts();
    }

    @GetMapping("/{id}")
    public ProductDto getById(@PathVariable Long id) {
        return this.productService.getProductById();
    }
}
