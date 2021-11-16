package com.example.demo.library.transaction;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.example.demo.library.book.BookEntity;
import com.example.demo.library.book.BookRepository;
import com.example.demo.library.reader.ReaderEntity;
import com.example.demo.library.reader.ReaderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionRestController {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ReaderRepository readerRepository;

    @GetMapping("")
    public Iterable<TransactionEntity> getAllTransactions(){
        List<TransactionEntity> response = StreamSupport
                .stream(transactionRepository.findAll().spliterator(), false).map(transaction -> transaction)
                .collect(Collectors.toList());
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransactionEntity> getTransactionById(@PathVariable Long id){
        try {
            TransactionEntity transaction = transactionRepository.findById(id).get();
            return transaction != null ? ResponseEntity.ok(transaction) : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return new ResponseEntity<TransactionEntity>(new TransactionEntity(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("")
    @ResponseStatus(value = HttpStatus.CREATED)
    public TransactionEntity createTransaction(@RequestBody TransactionRequest transaction){
        try {
            ReaderEntity user = this.readerRepository.findById(Long.valueOf(transaction.getUserId())).get();
            BookEntity book = this.bookRepository.findById(Long.valueOf(transaction.getBookId())).get();

            TransactionEntity newTransaction = 
            new TransactionEntity(
                transaction.getTransactionDate(),
                transaction.getStatusDate(),
                transaction.getDueDate(), 
                transaction.getStatus(), 
                book, user);
                return transactionRepository.save(newTransaction);
        } catch (Exception e) {
            return new TransactionEntity();
        }
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public TransactionEntity updateTransaction(@PathVariable Long id, @RequestBody TransactionEntity transaction){
        TransactionEntity transactionToUpdate = transactionRepository.findById(id).get();
        transactionToUpdate.setTransactionDate(transaction.getTransactionDate());
        transactionToUpdate.setStatusDate(transaction.getStatusDate());
        transactionToUpdate.setStatus(transaction.getStatus());
        transactionToUpdate.setBook(transaction.getBook());
        transactionToUpdate.setReader(transaction.getReader());
        return transactionRepository.save(transactionToUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteTransaction(@PathVariable Long id){
        try{
            transactionRepository.deleteById(id);
            return new ResponseEntity<Long>(id, HttpStatus.ACCEPTED);
        }catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<Long>(id, HttpStatus.BAD_REQUEST);
        }
    }
    
    @PatchMapping("{id}")
    public TransactionEntity patchTransaction(@PathVariable Long id, @RequestBody TransactionEntity transaction){
        TransactionEntity transactionToUpdate = transactionRepository.findById(id).get();
        if(transaction.getTransactionDate() != null ){
            transactionToUpdate.setTransactionDate(transaction.getTransactionDate());
        }
        if(transaction.getStatusDate() != null ){
            transactionToUpdate.setStatusDate(transaction.getStatusDate());
        }
        if(transaction.getStatus() != null){
            transactionToUpdate.setStatus(transaction.getStatus());
        }
        if(transaction.getDueDate() != null){
            transactionToUpdate.setDueDate(transaction.getDueDate());
        }
        return transactionRepository.save(transactionToUpdate);
    }
}
