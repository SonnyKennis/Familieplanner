package be.thomasmore.familieplanner.controllers;

import be.thomasmore.familieplanner.model.Boodschap;
import be.thomasmore.familieplanner.repository.BoodschapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoodschapController {

    @Autowired
    private BoodschapRepository boodschapRepository;

    @GetMapping("/boodschappenlijst")
    public String boodschappenlijst(Model model) {
        Iterable<Boodschap> boodschappen = boodschapRepository.findAll();
        model.addAttribute("boodschappen", boodschappen);
        model.addAttribute("nieuweBoodschap", new Boodschap());
        return "boodschappenlijst";
    }

    @PostMapping("/boodschappenlijst")
    public String addBoodschap(@ModelAttribute("nieuweBoodschap") Boodschap boodschap) {
        boodschapRepository.save(boodschap);
        return "redirect:/boodschappenlijst";
    }
}

