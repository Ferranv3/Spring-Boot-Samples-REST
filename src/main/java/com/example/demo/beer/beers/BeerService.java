package com.example.demo.beer.beers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
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

    public void saveAllBeers(){
        BeerResponse[] beersResponse = restTemplate.getForObject("https://api.punkapi.com/v2/beers", BeerResponse[].class);
        for (BeerResponse beerResponse : beersResponse) {
            BeerEntity beer = new BeerEntity(beerResponse.getId(), beerResponse.getName(), beerResponse.getFirstBrewed(), beerResponse.getDescription(), beerResponse.getImageUrl(), beerResponse.getAbv());
            this.repository.save(beer);
        }
    }

    public Iterable<BeerEntity> getFilteredBeers(String abvGt, String abvLt) {
        if (abvGt.isEmpty() && abvLt.isEmpty()) {
            return repository.findAll();
        } else if (abvGt.isEmpty() && !abvLt.isEmpty()) {
            double abvLtDouble = Double.parseDouble(abvLt);
            return repository.findByAbvLessThan(abvLtDouble);
        } else if (!abvGt.isEmpty() && abvLt.isEmpty()) {
            double abvGtDouble = Double.parseDouble(abvGt);
            return repository.findByAbvGreaterThan(abvGtDouble);
        } else if (!abvGt.isEmpty() && !abvLt.isEmpty()) {
            double abvGtDouble = Double.parseDouble(abvGt);
            double abvLtDouble = Double.parseDouble(abvLt);
            return repository.findByAbvGreaterThanAndAbvLessThan(abvGtDouble, abvLtDouble);
        }
        return repository.findAll();   
     }
}