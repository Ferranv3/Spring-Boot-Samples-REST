package com.example.demo.library;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookEntity, Long> {
  BookEntity findById(long id);
  BookEntity findByIsbn(long isbn);
  List<BookEntity> findByTitle(String title);
  List<BookEntity> findByAuthor(String author);
}
