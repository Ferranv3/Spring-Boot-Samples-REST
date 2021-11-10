package com.example.demo.astro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
@Controller
public class AstroPicController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AstroPicRepository repository;

    @GetMapping("/astropic")
    public String astropic(@RequestParam(name="name", required=false) String name, Model model) {
        //rest
        AstroResponse astro = restTemplate.getForObject("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY", AstroResponse.class);
        AstroPicEntity todayAstro = new AstroPicEntity(astro.getDate(), astro.getExplanation(), astro.getHdurl(), astro.getUrl(), astro.getTitle(), astro.getMediaType());
        //model.addAttribute("astro", repository.findAll());
        //normal de database
        this.repository.save(todayAstro);
        model.addAttribute("astropics", repository.findAll());
        return "astropic";
    }
}