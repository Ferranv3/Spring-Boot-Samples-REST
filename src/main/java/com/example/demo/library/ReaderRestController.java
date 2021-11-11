package com.example.demo.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ReaderRestController {
    @Autowired
    private ReaderRepository repository;

    @GetMapping("/reader")
    public Iterable<ReaderEntity> getAllLectors(){
        return repository.findAll();
    }
    @GetMapping("/reader/{id}")
    public ReaderEntity getById(@PathVariable Long id){
        return repository.findById(id).get();
    }

    @PostMapping("/reader")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ReaderEntity createCustomer(@RequestBody ReaderEntity lector){
        return repository.save(lector);
    }
}
