package com.example.Vitarico.domain.services.interfaces;

import com.example.Vitarico.domain.dto.SalesDto;

import java.util.List;

public interface SalesService {
    List<SalesDto> getSales();
    SalesDto getSaleById(Long id);
    void saveSale(SalesDto salesDto);
    void updateSale(SalesDto salesDto);
    void deleteSale(Long id);
}
