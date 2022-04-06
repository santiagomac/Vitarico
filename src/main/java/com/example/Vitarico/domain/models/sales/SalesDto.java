package com.example.Vitarico.domain.models.sales;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalesDto {

    private Long id;
    private LocalDateTime date;
    private String description;
    private Long customerId;
}