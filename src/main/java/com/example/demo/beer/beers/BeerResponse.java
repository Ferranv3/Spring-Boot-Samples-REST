package com.example.demo.beer.beers;
import java.util.List;

import javax.persistence.Column;

import com.example.demo.beer.purchases.PurchaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BeerResponse {
    private long id;
    private String name;

    @JsonProperty("first_brewed")
    private String firstBrewed;

    @Column(columnDefinition = "LONGTEXT")
    private String description;

    @JsonProperty("image_url")
    private String imageUrl;

    private float abv;
    private List<PurchaseEntity> purchases;

    public BeerResponse(){}

    public BeerResponse(long id, String name, String firstBrewed, String description, String imageUrl,float abv){
        this.id = id;
        this.name = name;
        this.firstBrewed = firstBrewed;
        this.description = description;
        this.imageUrl = imageUrl;
        this.abv = abv;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setFirstBrewed(String firstBrewed){
        this.firstBrewed = firstBrewed;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setImageUrl(String imageUrl){
        this.imageUrl = imageUrl;
    }

    public void setAbv(float abv){
        this.abv = abv;
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

    public String getFirstBrewed(){
        return this.firstBrewed;
    }

    public String getDescription(){
        return this.description;
    }

    public String getImageUrl(){
        return this.imageUrl;
    }

    public Float getAbv(){
        return this.abv;
    }

    public void addPurchase(PurchaseEntity purchase){
        this.purchases.add(purchase);
    }

    @Override
    public String toString() {
        String myPurchases = this.purchases.stream()
            .map(purchase -> purchase.toString())
            .reduce("", (acc, title) -> acc + title + ", ");
        return "LibraryUserEntity{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", firstBrewed='" + this.firstBrewed + '\'' +
                ", imageUrl='" + this.imageUrl + '\'' +
                ", abv='" + this.abv + '\'' +
                ", description='" + this.description + '\'' +
                ", purchases=" + myPurchases +
                '}';
    }
}
