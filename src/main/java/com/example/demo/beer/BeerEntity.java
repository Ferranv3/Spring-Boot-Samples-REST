package com.example.demo.beer;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BeerEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    
    private String name;
    private String firstBrewed;

    @Column(columnDefinition = "LONGTEXT")
    private String description;

    private String imageUrl;
    private float abv;

    public BeerEntity(){}

    public BeerEntity(int id,String name,String firstBrewed,String description,String imageUrl,float abv){
        this.id = id;
        this.name = name;
        this.firstBrewed = firstBrewed;
        this.description = description;
        this.imageUrl = imageUrl;
        this.abv = abv;
    }

    public int getId(){return this.id;}
    public String getName(){return this.name;}
    public String getFirstBrewed(){return this.firstBrewed;}
    public String getDescription(){return this.description;}
    public String getImageUrl(){return this.imageUrl;}
    public Float getAbv(){return this.abv;}
}
