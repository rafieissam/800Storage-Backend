package com.rafieissam.storage.controllers;

import com.rafieissam.storage.entities.Product;
import com.rafieissam.storage.requests.CreateProductInput;
import com.rafieissam.storage.requests.UpdateProductInput;
import com.rafieissam.storage.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    public ProductService productService;
    
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> allProducts() {
        List<Product> products = productService.findAll();

        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> oneProduct(@PathVariable int id) {
        Optional<Product> optionalProduct = productService.findById(id);

        if (optionalProduct.isPresent()) {
            return new ResponseEntity<>(optionalProduct.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody CreateProductInput createProductInput) {
        Product productCreated = productService.create(createProductInput.toProduct());

        return new ResponseEntity<>(productCreated, HttpStatus.CREATED);
    }

    @PatchMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody UpdateProductInput updateProductInput) {
        Optional<Product> optionalProduct = productService.findById(id);

        if (optionalProduct.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Product productToUpdate = optionalProduct.get();

        if (updateProductInput.name() != null)
            productToUpdate.setName(updateProductInput.name());
        if (updateProductInput.description() != null)
            productToUpdate.setDescription(updateProductInput.description());
        if (updateProductInput.category() != null)
            productToUpdate.setCategory(updateProductInput.category());

        Product productUpdated = productService.update(productToUpdate);

        return new ResponseEntity<>(productUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        productService.delete(id);

        return ResponseEntity.noContent().build();
    }
    
    
}
