package com.example.demo.astro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class AstroPicController {
    @Autowired
    private AstroPicRepository repository;

    @GetMapping("/astropic")
    public String astropic(@RequestParam(name="name", required=false) String name, Model model) {
        model.addAttribute("astropics", repository.findAll());
        return "astropic";
    }
}