package be.thomasmore.familieplanner.controller;

import be.thomasmore.familieplanner.model.Activity;
import be.thomasmore.familieplanner.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ActivityRepository activiteitRepository;

    @GetMapping("/activiteiten")
    public String lijstActiviteiten(Model model) {
        model.addAttribute("activiteiten", activiteitRepository.findAll());
        return "adminactiviteiten";
    }

    @GetMapping("/nieuweactiviteit")
    public String nieuweActiviteitForm(Model model) {
        model.addAttribute("activiteit", new Activity());
        return "nieuweactiviteit";
    }

    @PostMapping("/nieuweactiviteit")
    public String activiteitToevoegen(@ModelAttribute Activity activiteit) {
        activiteitRepository.save(activiteit);
        return "redirect:/admin/activiteiten";
    }
}
