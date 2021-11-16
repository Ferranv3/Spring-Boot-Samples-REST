package com.example.demo.beer.beers;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/beers")
public class BeerRestController {
    @Autowired
    private BeerRepository repository;

    @GetMapping("")
    public Iterable<BeerResponse> getAllBeers(
        @RequestParam(name="abv1", required=false, defaultValue = "") String abv1,
        @RequestParam(name="abv2", required=false, defaultValue = "") String abv2){

            Iterable<BeerResponse> beers = StreamSupport.stream(repository.findAll().spliterator(), false)
            .map(beer -> new BeerResponse(beer.getId(),beer.getName(), beer.getFirstBrewed(), beer.getDescription(), beer.getImageUrl(), beer.getAbv()))
            .collect(Collectors.toList());
            return beers;
    }

    @GetMapping("/{id}")
    public BeerResponse getBeerById(@PathVariable Long id){
        BeerEntity beer = repository.findById(id).get();
        return new BeerResponse(beer.getId(),beer.getName(), beer.getFirstBrewed(), beer.getDescription(), beer.getImageUrl(), beer.getAbv());
    }

    @PostMapping("")
    @ResponseStatus(value = HttpStatus.CREATED)
    public BeerEntity createBeer(@RequestBody BeerEntity beer){
        return repository.save(beer);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public BeerEntity updateBeer(@PathVariable Long id, @RequestBody BeerEntity beer){
        BeerEntity beerToUpdate = repository.findById(id).get();
        beerToUpdate.setName(beer.getName());
        beerToUpdate.setFirstBrewed(beer.getFirstBrewed());
        beerToUpdate.setDescription(beer.getDescription());
        beerToUpdate.setImageUrl(beer.getImageUrl());
        beerToUpdate.setAbv(beer.getAbv());
        return repository.save(beerToUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteBeer(@PathVariable Long id){
        try{
            repository.deleteById(id);
            return new ResponseEntity<Long>(id, HttpStatus.ACCEPTED);
        }catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<Long>(id, HttpStatus.BAD_REQUEST);
        }
    }
    
    @PatchMapping("{id}")
    public BeerEntity patchBeer(@PathVariable Long id, @RequestBody BeerEntity beer){
        BeerEntity beerToUpdate = repository.findById(id).get();
        if(beer.getName() != null ){
            beerToUpdate.setName(beer.getName());
        }
        if(beer.getFirstBrewed() != null ){
            beerToUpdate.setFirstBrewed(beer.getFirstBrewed());
        }
        if(beer.getImageUrl() != null){
            beerToUpdate.setImageUrl(beer.getImageUrl());
        }
        if(beer.getDescription() != null){
            beerToUpdate.setDescription(beer.getDescription());
        }
        if(beer.getAbv() != null){
            beerToUpdate.setAbv(beer.getAbv());
        }
        return repository.save(beerToUpdate);
    }
}
