package com.example.demo.beer.purchases;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.example.demo.beer.beers.BeerEntity;
import com.example.demo.beer.beers.BeerRepository;
import com.example.demo.beer.pubs.PubEntity;
import com.example.demo.beer.pubs.PubRepository;

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
@RequestMapping("/api/v1/purchases")
public class PurchaseRestController {
    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private BeerRepository beerRepository;

    @Autowired
    private PubRepository pubRepository;

    @GetMapping("")
    public Iterable<PurchaseResponse> getAllPurchases(){
        Iterable<PurchaseResponse> purchases = StreamSupport.stream(purchaseRepository.findAll().spliterator(), false)
        .map(purchase -> new PurchaseResponse(purchase.getId(),purchase.getPurchaseDate(), purchase.getPrice(), purchase.getStatus(), purchase.getBeer(), purchase.getPub()))
        .collect(Collectors.toList());
        return purchases;
    }

    @GetMapping("/{id}")
    public PurchaseResponse getPurchaseById(@PathVariable Long id){
        PurchaseEntity purchase = purchaseRepository.findById(id).get();
        return new PurchaseResponse(purchase.getId(),purchase.getPurchaseDate(), purchase.getPrice(), purchase.getStatus(), purchase.getBeer(), purchase.getPub());
    }

    @PostMapping("")
    @ResponseStatus(value = HttpStatus.CREATED)
    public PurchaseEntity createPurchase(@RequestBody PurchaseRequest purchase){
        try {
            BeerEntity user = this.beerRepository.findById(Long.valueOf(purchase.getBeer().getId())).get();
            PubEntity book = this.pubRepository.findById(Long.valueOf(purchase.getPub().getId())).get();

            PurchaseEntity newPurchase = 
            new PurchaseEntity(purchase.getPurchaseDate(), purchase.getPrice(), purchase.getStatus(), purchase.getBeer(), purchase.getPub());
                return purchaseRepository.save(newPurchase);
        } catch (Exception e) {
            return new PurchaseEntity();
        }
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public PurchaseEntity updatePurchase(@PathVariable Long id, @RequestBody PurchaseEntity purchase){
        PurchaseEntity purchaseToUpdate = purchaseRepository.findById(id).get();
        purchaseToUpdate.setPurchaseDate(purchase.getPurchaseDate());
        purchaseToUpdate.setPrice(purchase.getPrice());
        purchaseToUpdate.setStatus(purchase.getStatus());
        purchaseToUpdate.setBeer(purchase.getBeer());
        purchaseToUpdate.setPub(purchase.getPub());
        return purchaseRepository.save(purchaseToUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deletePurchase(@PathVariable Long id){
        try{
            purchaseRepository.deleteById(id);
            return new ResponseEntity<Long>(id, HttpStatus.ACCEPTED);
        }catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<Long>(id, HttpStatus.BAD_REQUEST);
        }
    }
    
    @PatchMapping("{id}")
    public PurchaseEntity patchPurchase(@PathVariable Long id, @RequestBody PurchaseEntity purchase){
        PurchaseEntity purchaseToUpdate = purchaseRepository.findById(id).get();
        if(purchase.getPurchaseDate() != null ){
            purchaseToUpdate.setPurchaseDate(purchase.getPurchaseDate());
        }
        if(purchase.getPrice() != null ){
            purchaseToUpdate.setPrice(purchase.getPrice());
        }
        if(purchase.getStatus() != null){
            purchaseToUpdate.setStatus(purchase.getStatus());
        }
        if(purchase.getBeer() != null){
            purchaseToUpdate.setBeer(purchase.getBeer());
        }
        if(purchase.getPub() != null){
            purchaseToUpdate.setPub(purchase.getPub());
        }
        return purchaseRepository.save(purchaseToUpdate);
    }
}
