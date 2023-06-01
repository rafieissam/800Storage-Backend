package com.rafieissam.storage.services;

import com.rafieissam.storage.entities.Product;
import com.rafieissam.storage.repositories.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);

        return products;
    }

    public Optional<Product> findById(int id) {
        return productRepository.findById(id);
    }

    public Product update(Product productToUpdate) {
        return productRepository.save(productToUpdate);
    }

    public void delete(int id) {
        productRepository.deleteById(id);
    }
}
