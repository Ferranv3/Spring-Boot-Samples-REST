package com.example.demo.library.library;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface LibraryRepository extends CrudRepository<LibraryEntity, Long> {
  LibraryEntity findById(long id);
  List<LibraryEntity> findByName(String name);
  List<LibraryEntity> findByCity(String city);
}
