package com.example.Vitarico.domain.services.impl;

import com.example.Vitarico.domain.entities.Product;
import com.example.Vitarico.domain.entities.Sales;
import com.example.Vitarico.domain.dto.SalesDto;
import com.example.Vitarico.domain.entities.SalesDetail;
import com.example.Vitarico.domain.repository.ProductRepository;
import com.example.Vitarico.domain.repository.SalesDetailRepository;
import com.example.Vitarico.domain.repository.SalesRepository;
import com.example.Vitarico.domain.services.interfaces.SalesService;
import com.example.Vitarico.infraestructure.utility.SalesMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SalesServiceImpl implements SalesService {

    private final SalesRepository salesRepository;
    private final SalesDetailRepository salesDetailRepository;
    private final ProductRepository productRepository;

    public SalesServiceImpl(SalesRepository salesRepository, SalesDetailRepository salesDetailRepository, ProductRepository productRepository) {
        this.salesRepository = salesRepository;
        this.salesDetailRepository = salesDetailRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<SalesDto> getSales() {
        List<Sales> sales = this.salesRepository.findAll();
        return sales.stream().map(SalesMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public SalesDto getSaleById(Long id) {
        Optional<Sales> sale = this.salesRepository.findById(id);
        List<SalesDetail> salesDetails = this.salesDetailRepository.findAll()
                .stream().filter(salesDetail -> Objects.equals(sale.get().getId(), salesDetail.getSaleId()))
                .collect(Collectors.toList());
        if(sale.isEmpty()){
            throw new RuntimeException("No existe la venta");
        }
        return SalesMapper.toDto(sale.get(), salesDetails);
    }

    @Override
    public void saveSale(SalesDto salesDto) {
        double total = 0;
        Sales sales = SalesMapper.toEntity(salesDto);
        Sales saleSaved = this.salesRepository.save(sales);
        List<SalesDetail> saleDetail = SalesMapper.toEntity(salesDto.getSalesDetailDto(), saleSaved.getId());
        for (SalesDetail salesDetail:
             saleDetail) {
            Optional<Product> product = this.productRepository.findById(salesDetail.getProductId());
            if(product.isEmpty()){
                throw new RuntimeException("No existe el producto con el id indicado");
            }
            total = total + product.get().getPrice() * salesDetail.getAmountProduct();
            Integer currentStock = product.get().getStock();
            Integer newStock = currentStock - salesDetail.getAmountProduct();
            product.get().setStock(newStock);
            this.productRepository.save(product.get());
        }
        sales.setTotal(total);
        this.salesRepository.save(sales);
        this.salesDetailRepository.saveAll(saleDetail);
    }

    @Override
    public void updateSale(SalesDto salesDto) {
        Sales sales = SalesMapper.toEntity(salesDto);
        this.salesRepository.save(sales);
    }

    @Override
    public void deleteSale(Long id) {
        this.salesRepository.deleteById(id);
    }
}
