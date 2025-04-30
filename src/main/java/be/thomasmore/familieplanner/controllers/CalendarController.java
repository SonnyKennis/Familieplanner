package be.thomasmore.familieplanner.controllers;
import be.thomasmore.familieplanner.model.Activity;
import be.thomasmore.familieplanner.repository.ActivityRepository;
import be.thomasmore.familieplanner.services.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.time.format.DateTimeFormatter;



@Controller
public class CalendarController {

    @Autowired
    private ActivityRepository activiteitRepository;

    @Autowired
    private CalendarService calendarService;

    @GetMapping("/calendar")
    public String calendarOverview(@RequestParam(value = "month", required = false) String month, Model model) {
        LocalDate today = LocalDate.now();
        YearMonth currentMonth;

        // Try parsing the provided month parameter or default to current month if invalid
        try {
            currentMonth = (month != null && !month.isEmpty()) ? YearMonth.parse(month, DateTimeFormatter.ofPattern("dd/MM/yyyy")) : YearMonth.from(today);
        } catch (DateTimeParseException e) {
            // If parsing fails, fallback to the current month
            currentMonth = YearMonth.from(today);
        }

        // Get the previous and next month for navigation
        YearMonth prevMonth = currentMonth.minusMonths(1);
        YearMonth nextMonth = currentMonth.plusMonths(1);

        // Format the months to "dd/MM/yyyy"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String prevMonthFormatted = prevMonth.atDay(1).format(formatter);
        String nextMonthFormatted = nextMonth.atDay(1).format(formatter);

        // Generate weeks for the current month
        List<List<LocalDate>> weeks = calendarService.generateWeeksForMonth(currentMonth);

        // Fetch all activities from the repository
        Iterable<Activity> activities = activiteitRepository.findAll();

        // Add necessary attributes to the model for Thymeleaf
        model.addAttribute("activities", activities);
        model.addAttribute("weeks", weeks);
        model.addAttribute("currentMonth", currentMonth.getMonth());
        model.addAttribute("currentYear", currentMonth.getYear());
        model.addAttribute("prevMonth", prevMonthFormatted); // Format to "dd/MM/yyyy"
        model.addAttribute("nextMonth", nextMonthFormatted); // Format to "dd/MM/yyyy"

        return "calendar";
    }

    @PostMapping("/calendar")
    public String CalendarOverviewPost(Activity activity) {
        activiteitRepository.save(activity);
        return "redirect:/calendar";  // redirects to the GET method
    }
}
