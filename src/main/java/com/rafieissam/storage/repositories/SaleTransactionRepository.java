package com.rafieissam.storage.repositories;

import com.rafieissam.storage.entities.SaleTransaction;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleTransactionRepository extends CrudRepository<SaleTransaction, Integer> {
    public List<SaleTransaction> findBySaleId(Integer saleId);
    public void deleteBySaleId(Integer saleId);
}