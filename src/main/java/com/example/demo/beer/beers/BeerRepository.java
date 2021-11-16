package com.example.demo.beer.beers;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
    
public interface BeerRepository extends CrudRepository<BeerEntity, Long> {
    BeerEntity findById(long id);
    List<BeerEntity> findByName(String name);
    List<BeerEntity> findByAbv(float abv);
    List<BeerEntity> findByAbvLessThan(Double abv);
    List<BeerEntity> findByAbvGreaterThan(Double abv);
    List<BeerEntity> findByAbvGreaterThanAndAbvLessThan(Double less, Double great);
}