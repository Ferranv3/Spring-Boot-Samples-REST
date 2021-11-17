package com.example.demo.beer.purchases;
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

import com.example.demo.beer.stock.BeerStockEntity;
import com.example.demo.beer.pubs.PubEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "purchase")
public class PurchaseEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    
    @JsonProperty("purchase_date")
    private String purchaseDate;
    private String price;
    private String status;
    private int cantity;

    @OneToMany(
        mappedBy = "purchase", 
        cascade = CascadeType.ALL, 
        fetch = javax.persistence.FetchType.LAZY)
    private List<BeerStockEntity> beerStock;

    @ManyToOne()
    @JoinColumn(name = "pub_id")
    private PubEntity pub;

    public PurchaseEntity(){}

    public PurchaseEntity(String purchaseDate,String price, String status, int cantity){
        this.purchaseDate = purchaseDate;
        this.price = price;
        this.status = status;
        this.cantity = cantity;
    }

    public PurchaseEntity(String purchaseDate,String price, String status, int cantity, List<BeerStockEntity> beerStock, PubEntity pub){
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
