package com.example.demo.beer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BeerService {
    
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private BeerRepository repository;

    public BeerService(){}

    public Iterable<BeerEntity> getAllBeers(){
        BeerResponse[] beersResponse = restTemplate.getForObject("https://api.punkapi.com/v2/beers", BeerResponse[].class);
        for (BeerResponse beerResponse : beersResponse) {
            BeerEntity beer = new BeerEntity(beerResponse.getId(), beerResponse.getName(), beerResponse.getFirstBrewed(), beerResponse.getDescription(), beerResponse.getImageUrl(), beerResponse.getAbv());
            this.repository.save(beer);
        }
        return this.repository.findAll();
    }
}