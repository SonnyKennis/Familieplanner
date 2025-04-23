package be.thomasmore.familieplanner.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CalendarController {

    @GetMapping("/calendaroverview")
    public String showCalendarPage() {
        return "calendaroverview"; // No .html needed
    }
}
