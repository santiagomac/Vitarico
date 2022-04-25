package com.example.Vitarico.domain.services.impl;

import com.example.Vitarico.domain.dto.ProductDto;
import com.example.Vitarico.domain.entities.Product;
import com.example.Vitarico.domain.enums.ExceptionResponse;
import com.example.Vitarico.domain.repository.ProductRepository;
import com.example.Vitarico.domain.services.interfaces.ProductService;
import com.example.Vitarico.exception.personalized.ProductException;
import com.example.Vitarico.infraestructure.utility.ProductMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private static final String PRODUCT = "product";

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDto> getProducts() {
        return this.productRepository.findAll()
                .stream().map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto getProductById(Long id) {
        Optional<Product> product = this.productRepository.findById(id);

        if (product.isEmpty()) {
            throw new ProductException(String.format(ExceptionResponse.NOT_FOUND.getMessage(), PRODUCT, id));
        }

        return ProductMapper.toDto(product.get());
    }

    @Override
    public void saveProduct(ProductDto productDto) {
        this.productRepository.save(ProductMapper.toEntity(productDto));
    }

    @Override
    public void updateProduct(Long id, ProductDto productDto) {
        Optional<Product> productToUpdate = this.productRepository.findById(id);
        if (productToUpdate.isEmpty()) {
            throw new ProductException(String.format(ExceptionResponse.NOT_FOUND.getMessage(), PRODUCT, id));
        }

        Product productUpdated = updateData(productToUpdate.get(), productDto);

        this.productRepository.save(productUpdated);
    }

    @Override
    public void deleteProduct(Long id) {
        Optional<Product> product = this.productRepository.findById(id);

        if (product.isEmpty()) {
            throw new ProductException(String.format(ExceptionResponse.NOT_FOUND.getMessage(), PRODUCT, id));
        }

        this.productRepository.deleteById(id);
    }


    private Product updateData(Product product, ProductDto productDto) {
        product.setCode(productDto.getCode());
        product.setPrice(productDto.getPrice());
        product.setName(productDto.getName());
        product.setStock(productDto.getStock());

        return product;
    }
}
