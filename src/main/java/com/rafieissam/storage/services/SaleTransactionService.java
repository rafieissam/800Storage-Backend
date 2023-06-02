package com.rafieissam.storage.services;

import com.rafieissam.storage.entities.SaleTransaction;
import com.rafieissam.storage.repositories.SaleTransactionRepository;

import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

@Service
public class SaleTransactionService {
    private final Logger logger = LoggerFactory.getLogger(SaleTransactionService.class);

    private final SaleTransactionRepository transactionRepository;
    
    public SaleTransactionService(SaleTransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public SaleTransaction create(SaleTransaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<SaleTransaction> findAll() {
        List<SaleTransaction> transactions = new ArrayList<>();
        transactionRepository.findAll().forEach(transactions::add);

        return transactions;
    }

    public List<SaleTransaction> findBySaleId(int saleId) {
        List<SaleTransaction> transactions = new ArrayList<>();
        transactionRepository.findBySaleId(saleId).forEach(transactions::add);

        return transactions;
    }

    public Optional<SaleTransaction> findById(int id) {
        return transactionRepository.findById(id);
    }

    public SaleTransaction update(SaleTransaction transactionToUpdate) {
        SaleTransaction updatedTransaction = transactionRepository.save(transactionToUpdate);
        logger.info("Transaction with ID {} of Sale with ID {} updated: New Quantity {}, New Price {}", updatedTransaction.getId(), updatedTransaction.getSale().getId(), updatedTransaction.getQuantity(), updatedTransaction.getPrice());
        return updatedTransaction;
    }

    public void delete(int id) {
        transactionRepository.deleteById(id);
    }

    @Transactional
    public void deleteBySaleId(int saleId) {
        transactionRepository.deleteBySaleId(saleId);
    }
}
