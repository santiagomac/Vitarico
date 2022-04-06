package com.example.Vitarico.controller;

import com.example.Vitarico.domain.models.sales.SalesDto;
import com.example.Vitarico.domain.services.interfaces.SalesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SalesController {

    private final SalesService salesService;

    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping
    public List<SalesDto> getSales() {
        return this.salesService.getSales();
    }

    @GetMapping("/{id}")
    public SalesDto getSaleById(@PathVariable Long id) {
        return this.salesService.getSaleById(id);
    }

    @PostMapping("/save")
    public void createSale(@RequestBody SalesDto salesDto) {
        this.salesService.saveSale(salesDto);
    }

    @PutMapping("/update")
    public void updateSale(@RequestBody SalesDto salesDto) {
        this.salesService.updateSale(salesDto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSale(@PathVariable Long id) {
        this.salesService.deleteSale(id);
    }
}

