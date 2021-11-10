package com.example.demo.astro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AstroPicService {
    
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AstroPicRepository repository;

    public AstroPicService(){}

    public AstroPicEntity getAstroPicData(String date){
        boolean repeated = false;
        AstroResponse astro = restTemplate.getForObject("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY&date=" + date, AstroResponse.class);
        Iterable<AstroPicEntity> astroCollection = this.repository.findAll();
        for(AstroPicEntity astroPic : astroCollection){
            if(astroPic.getDate().equals(astro.getDate())){
                repeated = true;
            }
        }

        if(!repeated){
            AstroPicEntity todayAstro = new AstroPicEntity(astro.getDate(), astro.getExplanation(), astro.getHdurl(), astro.getUrl(), astro.getTitle(), astro.getMediaType());
            this.repository.save(todayAstro);
        }
        
        return this.repository.findByDate(date);
    }

    public Iterable<AstroPicEntity> getAllAstroPicData(){
        AstroResponse astro = restTemplate.getForObject("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY", AstroResponse.class);
        AstroPicEntity todayAstro = new AstroPicEntity(astro.getDate(), astro.getExplanation(), astro.getHdurl(), astro.getUrl(), astro.getTitle(), astro.getMediaType());
        this.repository.save(todayAstro);
        return this.repository.findAll();
    }
}
