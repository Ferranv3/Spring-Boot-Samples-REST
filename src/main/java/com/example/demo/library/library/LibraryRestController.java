package com.example.demo.library.library;

import com.example.demo.library.book.BookEntity;
import com.example.demo.library.book.BookRepository;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/libraries")
public class LibraryRestController {
    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private ReaderRepository readerRepository;

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("")
    public Iterable<LibraryEntity> getAllLibrary(){
        return libraryRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryEntity> getById(@PathVariable Long id){
        try{
            LibraryEntity reader = libraryRepository.findById(id).get();
            return new ResponseEntity<LibraryEntity>(reader, HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<LibraryEntity>(new LibraryEntity(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("")
    @ResponseStatus(value = HttpStatus.CREATED)
    public LibraryEntity createCustomer(@RequestBody LibraryEntity reader){
        return libraryRepository.save(reader);
    }

    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public LibraryEntity updateReader(@PathVariable Long id, @RequestBody LibraryEntity library){
        LibraryEntity libraryToUpdate = libraryRepository.findById(id).get();
        libraryToUpdate.setName(library.getName());
        libraryToUpdate.setCity(library.getCity());
        /*libraryToUpdate.setBooks(library.getBooks());
        libraryToUpdate.setReaders(library.getReaders());*/
        return libraryRepository.save(libraryToUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteReader(@PathVariable Long id){
        try{
            libraryRepository.deleteById(id);
            return new ResponseEntity<Long>(id, HttpStatus.ACCEPTED);
        }catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<Long>(id, HttpStatus.BAD_REQUEST);
        }
    }
    
    @PatchMapping("{id}")
    public ResponseEntity<LibraryEntity> patchBook(@PathVariable Long id, 
                        @RequestBody LibraryEntity library,
                        @RequestParam(name="bookId", required = true, defaultValue = "") String bookId){
        LibraryEntity libraryToUpdate = libraryRepository.findById(id).get();
        if(bookId != null && !bookId.isEmpty()){
            try{
                BookEntity newbook = bookRepository.findById(Long.parseLong(bookId));
                if(newbook != null){
                    //libraryToUpdate.addBook(newbook);
                    //newbook.setLibrary(library);
                    bookRepository.save(newbook);
                }
            }catch(Exception e){
                System.out.println(e);
                return new ResponseEntity<LibraryEntity>(new LibraryEntity(), HttpStatus.BAD_REQUEST);
            }
        }
        libraryRepository.save(libraryToUpdate);
        return new ResponseEntity<LibraryEntity>(libraryToUpdate, HttpStatus.ACCEPTED);
    }

    /*@PatchMapping("{id}")
    public ResponseEntity<LibraryEntity> patchReader(@PathVariable Long id, 
                    @RequestBody LibraryEntity library,
                    @RequestParam(name="readerId", required = true, defaultValue = "") String readerId){
        LibraryEntity libraryToUpdate = libraryRepository.findById(id).get();
        if(readerId != null && !readerId.isEmpty()){
            try{
                ReaderEntity newReader = readerRepository.findById(Long.parseLong(readerId));
                if(newReader != null){
                    //libraryToUpdate.addReader(newReader);
                    newReader.setLibrary(library);
                    readerRepository.save(newReader);
                }
            }catch(Exception e){
                System.out.println(e);
                return new ResponseEntity<LibraryEntity>(new LibraryEntity(), HttpStatus.BAD_REQUEST);
            }
        }
        libraryRepository.save(libraryToUpdate);
        return new ResponseEntity<LibraryEntity>(libraryToUpdate, HttpStatus.ACCEPTED);
    }*/
}
