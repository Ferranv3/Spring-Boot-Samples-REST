package com.example.demo.beer.beers;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.beer.purchases.PurchaseEntity;
import com.example.demo.beer.stock.BeerStockEntity;
import com.example.demo.beer.storages.StorageEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "beer")
public class BeerEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    private String name;
    private String firstBrewed;

    @Column(columnDefinition = "LONGTEXT")
    private String description;

    private String imageUrl;
    private float abv;

    @ManyToOne()
    @JsonBackReference
    @JoinColumn(name = "beerstock_id")
    private BeerStockEntity beerStock;

    public BeerEntity(){}

    public BeerEntity(String name, String firstBrewed, String description, String imageUrl,float abv){
        this.name = name;
        this.firstBrewed = firstBrewed;
        this.description = description;
        this.imageUrl = imageUrl;
        this.abv = abv;
    }

    public BeerEntity(long id, String name, String firstBrewed, String description, String imageUrl,float abv){
        this.id = id;
        this.name = name;
        this.firstBrewed = firstBrewed;
        this.description = description;
        this.imageUrl = imageUrl;
        this.abv = abv;
    }

    public BeerEntity(long id, String name, String firstBrewed, String description, String imageUrl, float abv, BeerStockEntity beerStock){
        this.id = id;
        this.name = name;
        this.firstBrewed = firstBrewed;
        this.description = description;
        this.imageUrl = imageUrl;
        this.abv = abv;
        this.beerStock = beerStock;
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

    public void setBeerStock(BeerStockEntity beerStock){
        this.beerStock = beerStock;
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

    public BeerStockEntity getBeerStock(){
        return this.beerStock;
    }

    @Override
    public String toString() {
        return "LibraryUserEntity{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", firstBrewed='" + this.firstBrewed + '\'' +
                ", imageUrl='" + this.imageUrl + '\'' +
                ", abv='" + this.abv + '\'' +
                ", description='" + this.description + '\'' +
                ", beerStock=" + this.beerStock +
                '}';
    }
}
