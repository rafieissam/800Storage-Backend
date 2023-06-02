package com.rafieissam.storage.requests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.rafieissam.storage.entities.Sale;
import com.rafieissam.storage.entities.SaleTransaction;

public record CreateSaleInput(Integer client, Integer seller, List<CreateSaleTransactionInput> transactions) {
    public List<Object> toSale() {
        Sale sale = new Sale();
        
        float total = 0.0f;
        List<SaleTransaction> saleTransactions = new ArrayList<>();
        for (CreateSaleTransactionInput transactionInput: transactions) {
            SaleTransaction saleTransaction = transactionInput.toSaleTransaction();
            saleTransactions.add(saleTransaction);
            total += (saleTransaction.getQuantity() * saleTransaction.getPrice());
        }

        sale.setClientId(client)
            .setSellerId(seller)
            .setTotal(total);

        return Arrays.asList(sale, saleTransactions);
    }
}
