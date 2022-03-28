package com.example.Vitarico.controller;

import com.example.Vitarico.domain.entities.Sales;
import com.example.Vitarico.domain.models.sales.SalesDto;
import com.example.Vitarico.domain.services.interfaces.SalesService;
import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales")
public class SalesController {

    private final SalesService salesService;

    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @GetMapping
    public void getSales(){
        System.out.println(LocalDateTime.now());
    }

    @GetMapping("/{id}")
    public Sales getSaleById(@PathVariable Long id){
        return this.salesService.getSaleById(id);
    }

    @PostMapping("/save")
    public Sales createSale(@RequestBody SalesDto salesDto){
        return this.salesService.saveSales(salesDto);
    }
}
