package com.rafieissam.storage.requests;

import com.rafieissam.storage.entities.SaleTransaction;

public record CreateSaleTransactionInput(Integer product, Integer quantity, Float price) {
    public SaleTransaction toSaleTransaction() {
        SaleTransaction transaction = new SaleTransaction();
        
        transaction.setProductId(product)
            .setQuantity(quantity)
            .setPrice(price);

        return transaction;
    }
}
