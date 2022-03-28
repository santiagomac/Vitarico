package com.example.Vitarico.domain.models.sales;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalesDto {

    private LocalDateTime date;
    private String description;
    private Long customerId;
}
