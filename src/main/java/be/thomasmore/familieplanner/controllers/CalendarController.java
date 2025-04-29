package be.thomasmore.familieplanner.controllers;
import be.thomasmore.familieplanner.model.Activity;
import be.thomasmore.familieplanner.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CalendarController {


    @Autowired
    private ActivityRepository activiteitRepository;


    @GetMapping("/calendaroverview")
    public String calendarOverview(Model model) {
        Iterable<Activity> activities = activiteitRepository.findAll();
        model.addAttribute("activiteiten", activities);
        return "calendaroverview";
    }

    @PostMapping("/calendaroverview")
            public String CalendarOverviewPost()
    {

        return "calendaroverview";
    }
}
