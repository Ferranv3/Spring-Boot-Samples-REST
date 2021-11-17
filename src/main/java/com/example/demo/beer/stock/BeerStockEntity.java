package com.example.demo.beer.stock;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.beer.beers.BeerEntity;
import com.example.demo.beer.purchases.PurchaseEntity;
import com.example.demo.beer.storages.StorageEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "beerstock")
public class BeerStockEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    @JsonIgnore
    @OneToMany(
        mappedBy = "beerStock", 
        cascade = CascadeType.ALL, 
        fetch = javax.persistence.FetchType.LAZY)
    private List<BeerEntity> beers;

    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "storage_id")
    private StorageEntity storage;

    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "purchase_id")
    private PurchaseEntity purchase;

    public BeerStockEntity(){}

    public BeerStockEntity(List<BeerEntity> beers, StorageEntity storage, PurchaseEntity purchase){
        this.beers = beers;
        this.storage = storage;
        this.purchase = purchase;
    }

    public BeerStockEntity(long id, List<BeerEntity> beers, StorageEntity storage, PurchaseEntity purchase){
        this.id = id;
        this.beers = beers;
        this.storage = storage;
        this.purchase = purchase;
    }

    public void setBeers(List<BeerEntity> beers){
        this.beers = beers;
    }

    public void setStorage(StorageEntity storage){
        this.storage = storage;
    }

    public void setPurchase(PurchaseEntity purchase){
        this.purchase = purchase;
    }

    public long getId(){
        return this.id;
    }

    public List<BeerEntity> getBeers(){
        return this.beers;
    }

    public StorageEntity getStorage(){
        return this.storage;
    }

    public PurchaseEntity getPurchase(){
        return this.purchase;
    }

    @Override
    public String toString() {
        String myBeers = this.beers.stream()
            .map(beer -> beer.toString())
            .reduce("", (acc, title) -> acc + title + ", ");
        return "LibraryUserEntity{" +
                "id=" + this.id +
                ", storage='" + this.storage + '\'' +
                ", purchase='" + this.purchase + '\'' +
                ", beers=" + myBeers +
                '}';
    }
}
