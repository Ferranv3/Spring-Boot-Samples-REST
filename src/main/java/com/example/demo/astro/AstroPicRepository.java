
package com.example.demo.astro;

import org.springframework.data.repository.CrudRepository;
    
public interface AstroPicRepository extends CrudRepository<AstroPicEntity, Long> {
    AstroPicEntity findById(long id);
}
