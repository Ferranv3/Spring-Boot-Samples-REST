package com.example.demo.beer.purchases;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.beer.beers.BeerEntity;
import com.example.demo.beer.pubs.PubEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class PurchaseEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @JsonProperty("purchase_date")
    private String purchaseDate;
    private String price;
    private String status;

    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "beer_id")
    private BeerEntity beer;

    @ManyToOne()
    @JoinColumn(name = "pub_id")
    private PubEntity pub;

    public PurchaseEntity(){}

    public PurchaseEntity(String purchaseDate,String price, String status){
        this.purchaseDate = purchaseDate;
        this.price = price;
        this.status = status;
    }

    public PurchaseEntity(String purchaseDate,String price, String status, BeerEntity beer, PubEntity pub){
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
        return "PurchaseEntity{" +
                "id=" + this.id +
                ", purchaseDate='" + this.purchaseDate + '\'' +
                ", price='" + this.price + '\'' +
                ", status='" + this.status + '\'' +
                ", beer='" + this.beer + '\'' +
                ", pub='" + this.pub + '\'' +
                '}';
    }
}
