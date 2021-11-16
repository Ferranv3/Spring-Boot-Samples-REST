package com.example.demo.beer;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "pub")
public class PubEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    private String name;
    private String city;

    @JsonManagedReference
    @OneToMany(
        mappedBy = "pub", 
        cascade = CascadeType.ALL, 
        fetch = javax.persistence.FetchType.LAZY,
        orphanRemoval = true)
    private List<PurchaseEntity> purchases;
    
    public PubEntity(){}

    public PubEntity(int id,String name,String city){
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

    public int getId(){
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
