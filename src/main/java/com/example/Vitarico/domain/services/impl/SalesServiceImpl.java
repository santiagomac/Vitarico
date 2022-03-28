package com.example.Vitarico.domain.services.impl;

import com.example.Vitarico.domain.entities.Sales;
import com.example.Vitarico.domain.models.sales.SalesDto;
import com.example.Vitarico.domain.repository.SalesRepository;
import com.example.Vitarico.domain.services.interfaces.SalesService;
import com.example.Vitarico.infraestructure.utility.SalesMapper;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class SalesServiceImpl implements SalesService {

    private final SalesRepository salesRepository;

    public SalesServiceImpl(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    @Override
    public Sales getSaleById(Long id) {
        Optional<Sales> sale = this.salesRepository.findById(id);
        if(sale.isEmpty()){
            throw new RuntimeException("No existe la venta");
        }
        return sale.get();
    }

    @Override
    public Sales saveSales(SalesDto salesDto) {
        Sales sales = SalesMapper.toEntity(salesDto);
        return this.salesRepository.save(sales);
    }
}
