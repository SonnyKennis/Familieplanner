package be.thomasmore.familieplanner.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CalendarController {





    @GetMapping("/calendaroverview")
    public String CalendarOverview() {
        return "calendaroverview"; // No .html needed
    }
    @PostMapping("/calendaroverview")
            public String CalendarOverviewPost()
    {
        return "calendaroverview";
    }
}
