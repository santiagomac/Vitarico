package com.example.Vitarico.domain.services.interfaces;

import com.example.Vitarico.domain.dto.ProductDto;
import java.util.List;

public interface ProductService {

    List<ProductDto> getProducts();
    ProductDto getProductById(Long id);
    void saveProduct(ProductDto productDto);
    void updateProduct(Long id, ProductDto productDto);
    void deleteProduct(Long id);

}
