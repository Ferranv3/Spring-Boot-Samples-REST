package com.example.demo.beer.storages;
import java.util.List;

import com.example.demo.beer.stock.BeerStockEntity;

public class StorageResponse {
    private int id;
    private String name;
    private String city;
    private int cantity;
    private List<BeerStockEntity> beersStock;

    public StorageResponse(){}

    public StorageResponse(String name, String city, int cantity){
        this.name = name;
        this.city = city;
        this.cantity = cantity;
    }

    public StorageResponse(String name, String city, int cantity, List<BeerStockEntity> beersStock){
        this.name = name;
        this.city = city;
        this.cantity = cantity;
        this.beersStock = beersStock;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setCantity(int cantity){
        this.cantity = cantity;
    }

    public void setBeersStock(List<BeerStockEntity> beersStock){
        this.beersStock = beersStock;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getCity(){
        return this.city;
    }

    public int getCantity(){
        return this.cantity;
    }

    public List<BeerStockEntity> getBeersStock(){
        return this.beersStock;
    }

    @Override
    public String toString() {
        String myBeers = this.beersStock.stream()
            .map(beer -> beer.toString())
            .reduce("", (acc, title) -> acc + title + ", ");
        return "PurchaseEntity{" +
                "id=" + this.id +
                ", purchaseDate='" + this.name + '\'' +
                ", price='" + this.city + '\'' +
                ", cantity='" + this.cantity + '\'' +
                ", beers='" + myBeers + '\'' +
                '}';
    }
}
