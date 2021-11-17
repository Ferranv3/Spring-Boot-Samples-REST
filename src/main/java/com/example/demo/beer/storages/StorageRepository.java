package com.example.demo.beer.storages;

import org.springframework.data.repository.CrudRepository;
    
public interface StorageRepository extends CrudRepository<StorageEntity, Long> {
    StorageEntity findById(long id);
}