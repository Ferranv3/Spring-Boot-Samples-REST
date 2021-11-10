package com.example.demo.beer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BeerController {
    @Autowired
    private BeerService beerService;

    @GetMapping("/beers")
    public String beers(@RequestParam(name="name", required=false, defaultValue = "") String name, Model model) {
        model.addAttribute("beers", beerService.getAllBeers());
        return "beer";
    }
}