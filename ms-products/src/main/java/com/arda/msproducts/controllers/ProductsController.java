package com.arda.msproducts.controllers;

import com.arda.msproducts.dtos.ProductDTO;
import com.arda.msproducts.models.Product;
import com.arda.msproducts.services.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsController {
    private final ProductsService productsService;

    @GetMapping
    public ResponseEntity<List<Product>> findAllProducts(){
        return ResponseEntity.ok(productsService.findAllProducts());
    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<Product>> findProductById(@PathVariable String id){
        return ResponseEntity.ok(productsService.findProductById(id));
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product request)
    {
        return ResponseEntity.ok(productsService.save(request));
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id,@RequestBody ProductDTO product)
    {
        return ResponseEntity.ok(productsService.update(id, product));
    }
}
