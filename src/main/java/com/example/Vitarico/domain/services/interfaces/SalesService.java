package com.example.Vitarico.domain.services.interfaces;

import com.example.Vitarico.domain.entities.Sales;
import com.example.Vitarico.domain.models.sales.SalesDto;

public interface SalesService {
    Sales getSaleById(Long id);
    Sales saveSales(SalesDto salesDto);
}
