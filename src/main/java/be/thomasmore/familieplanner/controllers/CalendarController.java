package be.thomasmore.familieplanner.controllers;

import be.thomasmore.familieplanner.model.Activity;
import be.thomasmore.familieplanner.repository.ActivityRepository;
import be.thomasmore.familieplanner.services.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@Controller
public class CalendarController {


    @Autowired
    private ActivityRepository activiteitRepository;
    @Autowired
    private CalendarService calendarService;

    @GetMapping("/calendar")
    public String calendarOverview(Model model) {
        LocalDate today = LocalDate.now();
        YearMonth currentMonth = YearMonth.from(today);

        List<List<LocalDate>> weeks = calendarService.generateWeeksForMonth(currentMonth);
        Iterable<Activity> activities = activiteitRepository.findAll();

        model.addAttribute("activities", activities);
        model.addAttribute("weeks", weeks);
        model.addAttribute("currentMonth", currentMonth.getMonth());
        model.addAttribute("currentYear", currentMonth.getYear());

        return "calendar";
    }

    @PostMapping("/calendar")
    public String CalendarOverviewPost(Activity activity) {
        activiteitRepository.save(activity);
        return "redirect:/calendar";  // redirects to the GET method
    }

}
