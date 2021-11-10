
package com.example.demo;

import org.springframework.data.repository.CrudRepository;
    
public interface AstroPicRepository extends CrudRepository<AstroPic, Long> {
    AstroPic findById(long id);
}
