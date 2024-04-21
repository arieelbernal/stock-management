package com.arda.msproducts.models;

import io.swagger.v3.oas.annotations.media.Content;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(name = "minimum_stock",nullable = false)
    private Integer minimumStock;
    @Column(name = "reorder_point",nullable = false)
    private Integer reorderPoint;
    @Column(name = "current_stock",nullable = false)
    private Integer currentStock;
    @Column(nullable = false)
    private Double price;
}
