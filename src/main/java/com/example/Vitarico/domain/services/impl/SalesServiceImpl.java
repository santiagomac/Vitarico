package com.example.Vitarico.domain.services.impl;

import com.example.Vitarico.domain.entities.Sales;
import com.example.Vitarico.domain.models.sales.SalesDto;
import com.example.Vitarico.domain.repository.SalesRepository;
import com.example.Vitarico.domain.services.interfaces.SalesService;
import com.example.Vitarico.infraestructure.utility.SalesMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SalesServiceImpl implements SalesService {

    private final SalesRepository salesRepository;

    public SalesServiceImpl(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
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
        if(sale.isEmpty()){
            throw new RuntimeException("No existe la venta");
        }
        return SalesMapper.toDto(sale.get());
    }

    @Override
    public void saveSale(SalesDto salesDto) {
        Sales sales = SalesMapper.toEntity(salesDto);
        this.salesRepository.save(sales);
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
