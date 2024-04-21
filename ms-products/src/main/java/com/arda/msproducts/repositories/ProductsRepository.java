package com.arda.msproducts.repositories;

import com.arda.msproducts.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product, Long> {
}
