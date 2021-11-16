package com.example.demo.beer.purchases;

import com.example.demo.beer.beers.BeerEntity;
import com.example.demo.beer.pubs.PubEntity;

public class PurchaseResponse {
    private int id;
    private String purchaseDate;
    private String price;
    private String status;
    private BeerEntity beer;
    private PubEntity pub;

    public PurchaseResponse(){}

    public PurchaseResponse(int id,String purchaseDate,String price, String status){
        this.id = id;
        this.purchaseDate = purchaseDate;
        this.price = price;
        this.status = status;
    }

    public PurchaseResponse(int id,String purchaseDate,String price, String status, BeerEntity beer, PubEntity pub){
        this.id = id;
        this.purchaseDate = purchaseDate;
        this.price = price;
        this.status = status;
        this.beer = beer;
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

    public void setBeer(BeerEntity beer){
        this.beer = beer;
    }

    public void setPub(PubEntity pub){
        this.pub = pub;
    }

    public int getId(){
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

    public BeerEntity getBeer(){
        return this.beer;
    }

    public PubEntity getPub(){
        return this.pub;
    }

    @Override
    public String toString() {
        return "PurchaseResponse{" +
                "id=" + this.id +
                ", purchaseDate='" + this.purchaseDate + '\'' +
                ", price='" + this.price + '\'' +
                ", status='" + this.status + '\'' +
                ", beer='" + this.beer + '\'' +
                ", pub='" + this.pub + '\'' +
                '}';
    }
}
