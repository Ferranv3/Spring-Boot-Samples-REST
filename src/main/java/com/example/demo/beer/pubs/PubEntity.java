package com.example.demo.beer.pubs;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.beer.purchases.PurchaseEntity;

@Entity
@Table(name = "pub")
public class PubEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;
    
    private String name;
    private String city;

    @OneToMany(
        mappedBy = "pub", 
        cascade = CascadeType.ALL, 
        fetch = javax.persistence.FetchType.LAZY,
        orphanRemoval = true)
    private List<PurchaseEntity> purchases;
    
    public PubEntity(){}

    public PubEntity(long id,String name,String city){
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
        String myPurchases = this.purchases.stream()
            .map(purchase -> purchase.toString())
            .reduce("", (acc, title) -> acc + title + ", ");
        return "PubEntity{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", city='" + this.city + '\'' +
                ", purchases='" + myPurchases + '\'' +
                '}';
    }
}
