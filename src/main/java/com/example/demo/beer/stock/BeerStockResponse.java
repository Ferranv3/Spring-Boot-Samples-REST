package com.example.demo.beer.stock;
import java.util.List;

import com.example.demo.beer.beers.BeerEntity;
import com.example.demo.beer.purchases.PurchaseEntity;
import com.example.demo.beer.storages.StorageEntity;

public class BeerStockResponse {
    private long id;
    private List<BeerEntity> beers;
    private StorageEntity storage;
    private PurchaseEntity purchase;

    public BeerStockResponse(){}

    public BeerStockResponse(List<BeerEntity> beers, StorageEntity storage, PurchaseEntity purchase){
        this.beers = beers;
        this.storage = storage;
        this.purchase = purchase;
    }

    public BeerStockResponse(long id, List<BeerEntity> beers, StorageEntity storage, PurchaseEntity purchase){
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
