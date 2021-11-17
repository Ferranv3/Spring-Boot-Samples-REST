package com.example.demo.beer.purchases;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PurchaseRequest {
    @JsonProperty("purchase_date")
    private String purchaseDate;

    private String price;
    private String status;
    private int cantity;

    @JsonProperty("beer_id")
    private String beerID;

    @JsonProperty("pub_id")
    private String pubID;

    public PurchaseRequest(){}

    public PurchaseRequest(String purchaseDate,String price, String status, int cantity){
        this.purchaseDate = purchaseDate;
        this.price = price;
        this.status = status;
        this.cantity = cantity;
    }

    public PurchaseRequest(String purchaseDate,String price, String status, int cantity, String beerID, String pubID){
        this.purchaseDate = purchaseDate;
        this.price = price;
        this.status = status;
        this.cantity = cantity;
        this.beerID = beerID;
        this.pubID = pubID;
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

    public void setBeerID(String beerID){
        this.beerID = beerID;
    }

    public void setPubID(String pubID){
        this.pubID = pubID;
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

    public String getBeerID(){
        return this.beerID;
    }

    public String getPubID(){
        return this.pubID;
    }

    @Override
    public String toString() {
        return "PurchaseRequest{" +
                ", purchaseDate='" + this.purchaseDate + '\'' +
                ", price='" + this.price + '\'' +
                ", cantity='" + this.cantity + '\'' +
                ", status='" + this.status + '\'' +
                ", beer='" + this.beerID + '\'' +
                ", pub='" + this.pubID + '\'' +
                '}';
    }
}
