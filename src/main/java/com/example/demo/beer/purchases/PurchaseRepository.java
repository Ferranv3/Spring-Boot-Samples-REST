package com.example.demo.beer.purchases;

import org.springframework.data.repository.CrudRepository;
    
public interface PurchaseRepository extends CrudRepository<PurchaseEntity, Long> {
    PurchaseEntity findById(long id);
}