package com.example.demo.library;

import java.util.List;

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
@RequestMapping("/api/v1")
public class BookRestController {
    @Autowired
    private BookRepository repository;

    @GetMapping("/books")
    public Iterable<BookEntity> getAllBooks(){
        return repository.findAll();
    }

    @GetMapping("/books/{id}")
    public BookEntity getBookById(@PathVariable Long id){
        return repository.findById(id).get();
    }

    @GetMapping("/books/{tittle}")
    public List<BookEntity> getByName(@PathVariable String title){
        return repository.findByTitle(title);
    }

    @PostMapping("/book")
    @ResponseStatus(value = HttpStatus.CREATED)
    public BookEntity createBook(@RequestBody BookEntity book){
        return repository.save(book);
    }
    
    @PutMapping("/book/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public BookEntity updateBook(@PathVariable Long isbn, @RequestBody BookEntity book){
        BookEntity bookToUpdate = repository.findByIsbn(isbn);
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setAuthor(book.getAuthor());
        bookToUpdate.setDescription(book.getDescription());
        return repository.save(bookToUpdate);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Long> deleteBook(@PathVariable Long id){
        try{
            repository.deleteById(id);
            return new ResponseEntity<Long>(id, HttpStatus.ACCEPTED);
        }catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<Long>(id, HttpStatus.BAD_REQUEST);
        }
    }
    
    @PatchMapping("/book/{id}")
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
        return repository.save(bookToUpdate);
    }
}
