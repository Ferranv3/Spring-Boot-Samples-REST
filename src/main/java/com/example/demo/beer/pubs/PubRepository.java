package com.example.demo.beer.pubs;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
    
public interface PubRepository extends CrudRepository<PubEntity, Long> {
    List<PubEntity> findByName(String name);
    PubEntity findById(long id);
}