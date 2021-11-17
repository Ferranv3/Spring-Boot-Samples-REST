package com.example.demo.beer.stock;

import org.springframework.data.repository.CrudRepository;
    
public interface BeerStockRepository extends CrudRepository<BeerStockEntity, Long> {
    BeerStockEntity findById(long id);
}