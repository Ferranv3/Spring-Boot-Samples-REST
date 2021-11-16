package com.example.demo.beer.beers;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
    
public interface BeerRepository extends CrudRepository<BeerEntity, Long> {
    BeerEntity findById(long id);
    List<BeerEntity> findByName(String name);
    List<BeerEntity> findByAbv(float abv);
    List<BeerEntity> findByAbvLessThanEqual(Double abv);
    List<BeerEntity> findByAbvGreaterThanEqual(Double abv);
    List<BeerEntity> findByAbvLessThanEqualAndAbvGreaterThanEqual(Double less, Double great);
}