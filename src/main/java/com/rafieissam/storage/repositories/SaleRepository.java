package com.rafieissam.storage.repositories;

import com.rafieissam.storage.entities.Sale;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends CrudRepository<Sale, Integer> {

}