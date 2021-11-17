package com.example.demo.beer.purchases;

import java.util.List;

import com.example.demo.beer.beers.BeerEntity;
import com.example.demo.beer.pubs.PubEntity;
import com.example.demo.beer.stock.BeerStockEntity;

public class PurchaseResponse {
    private long id;
    private String purchaseDate;
    private String price;
    private String status;
    private int cantity;
    private List<BeerStockEntity> beerStock;
    private PubEntity pub;

    public PurchaseResponse(){}

    public PurchaseResponse(String purchaseDate,String price, String status, int cantity){
        this.purchaseDate = purchaseDate;
        this.price = price;
        this.status = status;
        this.cantity = cantity;
    }

    public PurchaseResponse(long id, String purchaseDate,String price, String status, int cantity, List<BeerStockEntity> beerStock, PubEntity pub){
        this.purchaseDate = purchaseDate;
        this.price = price;
        this.status = status;
        this.cantity = cantity;
        this.beerStock = beerStock;
        this.pub = pub;
    }

    public void setPurchaseDate(String purchaseDate){
        this.purchaseDate = purchaseDate;
    }

    public void setPrice(String price){
        this.price = price;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setCantity(int cantity){
        this.cantity = cantity;
    }

    public void setBeer(List<BeerStockEntity> beerStock){
        this.beerStock = beerStock;
    }

    public void setPub(PubEntity pub){
        this.pub = pub;
    }

    public long getId(){
        return this.id;
    }

    public String getPurchaseDate(){
        return this.purchaseDate;
    }

    public String getPrice(){
        return this.price;
    }

    public String getStatus(){
        return this.status;
    }

    public int getCantity(){
        return this.cantity;
    }

    public List<BeerStockEntity> getBeer(){
        return this.beerStock;
    }

    public PubEntity getPub(){
        return this.pub;
    }

    @Override
    public String toString() {
        String myBeerStock = this.beerStock.stream()
            .map(beer -> beer.toString())
            .reduce("", (acc, title) -> acc + title + ", ");
        return "PurchaseEntity{" +
                "id=" + this.id +
                ", purchaseDate='" + this.purchaseDate + '\'' +
                ", price='" + this.price + '\'' +
                ", cantity='" + this.cantity + '\'' +
                ", status='" + this.status + '\'' +
                ", beerStock='" + myBeerStock + '\'' +
                ", pub='" + this.pub + '\'' +
                '}';
    }
}
