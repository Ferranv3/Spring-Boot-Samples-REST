package com.example.demo.astro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AstroPicController {
    @Autowired
    private AstroPicService astroPicService;

    @GetMapping("/astropic")
    public String astropic(@RequestParam(name="date", required=false, defaultValue = "") String date, Model model) {
        if(!date.isEmpty()){
            model.addAttribute("astropics", astroPicService.getAstroPicData(date));
        }else{
            model.addAttribute("astropics", astroPicService.getAllAstroPicData());
        }
        
        return "astropic";
    }
}