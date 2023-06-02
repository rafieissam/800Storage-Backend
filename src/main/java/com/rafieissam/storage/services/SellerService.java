package com.rafieissam.storage.services;

import com.rafieissam.storage.entities.Seller;
import com.rafieissam.storage.repositories.SellerRepository;


import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class SellerService {

    private final SellerRepository sellerRepository;
    
    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public Optional<Seller> findById(int id) {
        return sellerRepository.findById(id);
    }
}
