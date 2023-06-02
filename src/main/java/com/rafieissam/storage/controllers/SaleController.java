package com.rafieissam.storage.controllers;

import com.rafieissam.storage.entities.Sale;
import com.rafieissam.storage.entities.SaleTransaction;
import com.rafieissam.storage.requests.CreateSaleInput;
import com.rafieissam.storage.requests.UpdateSaleInput;
import com.rafieissam.storage.services.ClientService;
import com.rafieissam.storage.services.SaleService;
import com.rafieissam.storage.services.SaleTransactionService;
import com.rafieissam.storage.services.SellerService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SaleController {
    public SaleService saleService;
    public SaleTransactionService saleTransactionService;
    public ClientService clientService;
    public SellerService sellerService;
    
    public SaleController(SaleService saleService, SaleTransactionService saleTransactionService) {
        this.saleService = saleService;
        this.saleTransactionService = saleTransactionService;
    }

    @GetMapping("/sales")
    public ResponseEntity<List<Sale>> allSales() {
        List<Sale> sales = saleService.findAll();

        return new ResponseEntity<>(sales, HttpStatus.OK);
    }

    @GetMapping("/sales/{id}")
    public ResponseEntity<Sale> oneSale(@PathVariable int id) {
        Optional<Sale> optionalSale = saleService.findById(id);

        if (optionalSale.isPresent()) {
            return new ResponseEntity<>(optionalSale.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/sales")
    public ResponseEntity<Sale> createSale(@RequestBody CreateSaleInput createSaleInput) {
        List<Object> object = createSaleInput.toSale();
        if (!(object.get(0) instanceof Sale)) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        Sale sale = (Sale) object.get(0);
        List<SaleTransaction> saleTransactions = new ArrayList<>();
        if (object.size() >= 2 && object.get(1) instanceof List) {
            List<?> transactionList = (List<?>) object.get(1);
            for (Object transaction : transactionList) {
                if (transaction instanceof SaleTransaction) {
                    SaleTransaction saleTransaction = (SaleTransaction) transaction;
                    saleTransactions.add(saleTransaction);
                }
            }
        }
        
        Sale saleCreated = saleService.create(sale);
        List<SaleTransaction> createdSaleTransactions = new ArrayList<>();
        for (SaleTransaction saleTransaction: saleTransactions) {
            saleTransaction.setSaleId(sale.getId());
            SaleTransaction createdSaleTransaction = saleTransactionService.create(saleTransaction);
            createdSaleTransactions.add(createdSaleTransaction);
        }
        
        return new ResponseEntity<>(saleCreated, HttpStatus.CREATED);
    }

    @PatchMapping("/sales/{sale_id}/transactions/{transaction_id}")
    public ResponseEntity<Sale> updateSale(@PathVariable int sale_id, @PathVariable int transaction_id, @RequestBody UpdateSaleInput updateSaleInput) {
        Optional<Sale> optionalSale = saleService.findById(sale_id);
        Optional<SaleTransaction> optionalSaleTransaction = saleTransactionService.findById(transaction_id);

        if (optionalSale.isEmpty() || optionalSaleTransaction.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Sale saleToUpdate = optionalSale.get();
        SaleTransaction saleTransactionToUpdate = optionalSaleTransaction.get();

        if (updateSaleInput.quantity() != null)
            saleTransactionToUpdate.setQuantity(updateSaleInput.quantity());
        if (updateSaleInput.price() != null)
            saleTransactionToUpdate.setPrice(updateSaleInput.price());

        saleTransactionService.update(saleTransactionToUpdate);

        List<SaleTransaction> saleTransactions = saleTransactionService.findBySaleId(sale_id);

        float total = 0.0f;
        for (SaleTransaction saleTransaction: saleTransactions) {
            total += (saleTransaction.getQuantity() * saleTransaction.getPrice());
        }
        
        saleToUpdate.setTotal(total);

        Sale saleUpdated = saleService.update(saleToUpdate);

        return new ResponseEntity<>(saleUpdated, HttpStatus.OK);
    }

    @DeleteMapping("/sales/{id}")
    public ResponseEntity<Void> deleteSale(@PathVariable int id) {
        saleTransactionService.deleteBySaleId(id);
        saleService.delete(id);

        return ResponseEntity.noContent().build();
    }
    
    
}
