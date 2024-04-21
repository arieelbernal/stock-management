package com.arda.msproducts.services;

import com.arda.msproducts.dtos.ProductDTO;
import com.arda.msproducts.models.Product;
import com.arda.msproducts.repositories.ProductsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductsService {
    private final ProductsRepository productsRepository;

    public List<Product> findAllProducts(){
        return productsRepository.findAll();
    }

    public Optional<Product> findProductById(String id){
        Long idParsed = Long.parseLong(id);
        return productsRepository.findById(idParsed);
    }

    public Product save(Product newProduct){
        return productsRepository.save(newProduct);
    }

    public Product update(String id, ProductDTO product)
    {
        Product productFound = productsRepository
                .findById(Long.parseLong(id))
                .orElseThrow(() -> new RuntimeException("Product not found"));

        productFound.setName(product.getName() != null
                && product.getName().isEmpty()
                ? product.getName()
                : productFound.getName()
        );
        productFound.setMinimumStock(product.getMinimumStock() != null
                ? product.getMinimumStock()
                : productFound.getMinimumStock()
        );
        productFound.setReorderPoint(product.getReorderPoint() != null
                ? product.getReorderPoint()
                : productFound.getReorderPoint()
        );
        productFound.setCurrentStock(product.getCurrentStock() != null
                ? product.getCurrentStock()
                : productFound.getCurrentStock()
        );
        productFound.setPrice(product.getPrice() != null
                ? product.getPrice()
                : productFound.getPrice()
        );
        return productsRepository.save(productFound);
    }
}
