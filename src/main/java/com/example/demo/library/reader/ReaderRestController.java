package com.example.demo.library.reader;

import com.example.demo.library.book.BookEntity;
import com.example.demo.library.book.BookRepository;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/readers")
public class ReaderRestController {
    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("")
    public Iterable<ReaderEntity> getAllLectors(){
        return readerRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReaderEntity> getReaderById(@PathVariable Long id){
        try{
            return new ResponseEntity<ReaderEntity>(readerRepository.findById(id).get(), HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<ReaderEntity>(new ReaderEntity(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ReaderEntity createCustomer(@RequestBody ReaderEntity reader){
        return readerRepository.save(reader);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ReaderEntity updateReader(@PathVariable Long id, @RequestBody ReaderEntity reader){
        ReaderEntity readerToUpdate = readerRepository.findById(id).get();
        readerToUpdate.setFirstName(reader.getFirstName());
        readerToUpdate.setLastName(reader.getLastName());
        readerToUpdate.setLastName(reader.getLastName());
        //readerToUpdate.setBooks(reader.getBooks());
        return readerRepository.save(readerToUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteReader(@PathVariable Long id){
        try{
            readerRepository.deleteById(id);
            return new ResponseEntity<Long>(id, HttpStatus.ACCEPTED);
        }catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<Long>(id, HttpStatus.BAD_REQUEST);
        }
    }
    
    @PatchMapping("{id}")
    public ResponseEntity<ReaderEntity> patchReader(@PathVariable Long id, @RequestBody ReaderEntity reader, 
                        @RequestParam(name="book_id", required = true, defaultValue = "") String bookId){
        ReaderEntity readerToUpdate = readerRepository.findById(id).get();
        if(bookId != null && !bookId.isEmpty()){
            try{
                BookEntity newbook = bookRepository.findById(Long.parseLong(bookId));
                if(newbook != null){
                    //readerToUpdate.addBook(newbook);
                    //newbook.setUser(readerToUpdate);
                    bookRepository.save(newbook);
                }
            }catch(Exception e){
                System.out.println(e);
                return new ResponseEntity<ReaderEntity>(new ReaderEntity(), HttpStatus.BAD_REQUEST);
            }
        }
        readerRepository.save(readerToUpdate);
        return new ResponseEntity<ReaderEntity>(readerToUpdate, HttpStatus.ACCEPTED);
    }
}
