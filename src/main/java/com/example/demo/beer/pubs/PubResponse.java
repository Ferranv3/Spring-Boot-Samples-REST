package com.example.demo.beer.pubs;
import java.util.List;

import com.example.demo.beer.purchases.PurchaseEntity;

public class PubResponse {
    private long id;
    private String name;
    private String city;
    private List<PurchaseEntity> purchases;
    
    public PubResponse(){}

    public PubResponse(long id,String name,String city){
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setPurchases(List<PurchaseEntity> purchases){
        this.purchases = purchases;
    }

    public long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getCity(){
        return this.city;
    }

    public void addPurchase(PurchaseEntity purchase){
        this.purchases.add(purchase);
    }

    @Override
    public String toString() {
        return "PubEntity{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", city='" + this.city + '\'' +
                '}';
    }
}
