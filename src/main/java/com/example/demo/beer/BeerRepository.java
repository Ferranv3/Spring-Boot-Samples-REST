package com.example.demo.beer;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
    
public interface BeerRepository extends CrudRepository<BeerEntity, Long> {
    List<BeerEntity> findByName(String name);
    List<BeerEntity> findByAbv(float abv);
    BeerEntity findById(long id);
}