package com.example.demo.beer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BeerResponse {
    private int id;
    private String name;
    @JsonProperty("first_brewed")
    private String firstBrewed;
    private String description;
    @JsonProperty("image_url")
    private String imageUrl;
    private float abv;

    public BeerResponse(){}

    public BeerResponse(int id,String name,String firstBrewed,String description,String imageUrl,float abv){
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