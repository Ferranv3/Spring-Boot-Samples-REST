package com.example.demo.library.reader;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface ReaderRepository extends CrudRepository<ReaderEntity, Long> {
  ReaderEntity findById(long id);
  /*List<ReaderEntity> findByFirstName(String firstName);
  List<ReaderEntity> findByLastName(String lastName);*/
}
