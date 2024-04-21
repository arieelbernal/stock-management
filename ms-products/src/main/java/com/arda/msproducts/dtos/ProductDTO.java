package com.arda.msproducts.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private String name;
    private Integer minimumStock;
    private Integer reorderPoint;
    private Integer currentStock;
    private Double price;
}
