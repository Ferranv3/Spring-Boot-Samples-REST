package com.example.demo.library.transaction;

import java.util.List;

import com.example.demo.library.book.BookEntity;

import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<TransactionEntity, Long> {
  BookEntity findById(long id);
  /*List<TransactionEntity> findByBook(String book);
  List<TransactionEntity> findByReader(String reader);*/
}
