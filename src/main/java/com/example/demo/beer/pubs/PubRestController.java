package com.example.demo.beer.pubs;

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
@RequestMapping("/api/v1/pubs")
public class PubRestController {
    @Autowired
    private PubRepository repository;

    @GetMapping("")
    public Iterable<PubResponse> getAllPubs(){
        Iterable<PubResponse> pubs = StreamSupport.stream(repository.findAll().spliterator(), false)
        .map(pub -> new PubResponse(pub.getId(),pub.getName(), pub.getCity()))
        .collect(Collectors.toList());
        return pubs;
    }

    @GetMapping("/{id}")
    public PubResponse getPubById(@PathVariable Long id){
        PubEntity pub = repository.findById(id).get();
        return new PubResponse(pub.getId(),pub.getName(), pub.getCity());
    }

    @PostMapping("")
    @ResponseStatus(value = HttpStatus.CREATED)
    public PubEntity createPub(@RequestBody PubEntity pub){
        return repository.save(pub);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public PubEntity updatePub(@PathVariable Long id, @RequestBody PubEntity pub){
        PubEntity pubToUpdate = repository.findById(id).get();
        pubToUpdate.setName(pub.getName());
        pubToUpdate.setCity(pub.getCity());
        return repository.save(pubToUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deletePub(@PathVariable Long id){
        try{
            repository.deleteById(id);
            return new ResponseEntity<Long>(id, HttpStatus.ACCEPTED);
        }catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<Long>(id, HttpStatus.BAD_REQUEST);
        }
    }
    
    @PatchMapping("{id}")
    public PubEntity patchPub(@PathVariable Long id, @RequestBody PubEntity pub){
        PubEntity pubToUpdate = repository.findById(id).get();
        if(pub.getName() != null ){
            pubToUpdate.setName(pub.getName());
        }
        if(pub.getCity() != null ){
            pubToUpdate.setCity(pub.getCity());
        }
        return repository.save(pubToUpdate);
    }
}
