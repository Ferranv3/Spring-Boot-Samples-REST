package com.example.demo.library;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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
@RequestMapping("/api/v1/library/books")
public class BookRestController {
    @Autowired
    private BookRepository repository;

    @GetMapping("")
    public Iterable<BookResponse> getAllBooks(){
        Iterable<BookResponse> books = StreamSupport.stream(repository.findAll().spliterator(), false)
        .map(book -> new BookResponse(book.getId(),book.getIsbn(), book.getTitle(), book.getAuthor(), book.getDescription(), book.isAvailable()))
        .collect(Collectors.toList());
        return books;
    }

    @GetMapping("/{id}")
    public BookResponse getBookById(@PathVariable Long id){
        BookEntity book = repository.findById(id).get();
        return new BookResponse(book.getId(),book.getIsbn(), book.getTitle(), book.getAuthor(), book.getDescription(), book.isAvailable();
    }

    @GetMapping("/{tittle}")
    public List<BookResponse> getByName(@PathVariable String title){
        List<BookResponse> books = StreamSupport.stream(repository.findAll().spliterator(), false)
        .map(book -> new BookResponse(book.getId(),book.getIsbn(), book.getTitle(), book.getAuthor(), book.getDescription(), book.isAvailable()))
        .collect(Collectors.toList());
        return books;
    }

    @PostMapping("")
    @ResponseStatus(value = HttpStatus.CREATED)
    public BookEntity createBook(@RequestBody BookEntity book){
        return repository.save(book);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public BookEntity updateBook(@PathVariable Long id, @RequestBody BookEntity book){
        BookEntity bookToUpdate = repository.findById(id).get();
        bookToUpdate.setIsbn(book.getIsbn());
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setAuthor(book.getAuthor());
        bookToUpdate.setDescription(book.getDescription());
        bookToUpdate.setAvailable(book.isAvailable());
        return repository.save(bookToUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteBook(@PathVariable Long id){
        try{
            repository.deleteById(id);
            return new ResponseEntity<Long>(id, HttpStatus.ACCEPTED);
        }catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<Long>(id, HttpStatus.BAD_REQUEST);
        }
    }
    
    @PatchMapping("{id}")
    public BookEntity patchBook(@PathVariable Long id, @RequestBody BookEntity book){
        BookEntity bookToUpdate = repository.findById(id).get();
        if(book.getIsbn() != null ){
            bookToUpdate.setIsbn(book.getIsbn());
        }
        if(book.getTitle() != null ){
            bookToUpdate.setTitle(book.getTitle());
        }
        if(book.getAuthor() != null){
            bookToUpdate.setAuthor(book.getAuthor());
        }
        if(book.getDescription() != null){
            bookToUpdate.setDescription(book.getDescription());
        }
        bookToUpdate.setAvailable(book.isAvailable());
        return repository.save(bookToUpdate);
    }
}
