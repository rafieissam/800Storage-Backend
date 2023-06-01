package com.rafieissam.storage.requests;

import com.rafieissam.storage.entities.Product;

public record CreateProductInput(String name, String description, String category) {
    public Product toProduct() {
        Product product = new Product();

        product.setName(name)
            .setDescription(description)
            .setCategory(category);

        return product;
    }
}
