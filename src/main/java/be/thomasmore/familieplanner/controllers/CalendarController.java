package be.thomasmore.familieplanner.controllers;

import be.thomasmore.familieplanner.model.Activity;
import be.thomasmore.familieplanner.model.Tasks; // Correct import for Tasks model
import be.thomasmore.familieplanner.repository.ActivityRepository;
import be.thomasmore.familieplanner.repository.TasksRepository; // Ensure correct repository is imported
import be.thomasmore.familieplanner.services.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Controller
public class CalendarController {

    @Autowired
    private ActivityRepository activiteitRepository;

    @Autowired
    private CalendarService calendarService;

    @Autowired
    private TasksRepository tasksRepository; // Correct repository for Tasks

    @GetMapping("/calendar")
    public String calendarOverview(@RequestParam(value = "month", required = false) String month, Model model) {
        LocalDate today = LocalDate.now();
        YearMonth currentMonth;

        try {
            currentMonth = (month != null && !month.isEmpty()) ?
                    YearMonth.parse(month, DateTimeFormatter.ofPattern("dd/MM/yyyy")) :
                    YearMonth.from(today);
        } catch (DateTimeParseException e) {
            currentMonth = YearMonth.from(today);
        }

        // Get the previous and next month for navigation
        YearMonth prevMonth = currentMonth.minusMonths(1);
        YearMonth nextMonth = currentMonth.plusMonths(1);

        // Generate weeks for the current month
        List<List<LocalDate>> weeks = calendarService.generateWeeksForMonth(currentMonth);

        // Fetch all activities and tasks from the repository
        Iterable<Activity> activities = activiteitRepository.findAll();
        Iterable<Tasks> tasks = tasksRepository.findAll(); // Fetch tasks using the Tasks repository

        // Add necessary attributes to the model
        model.addAttribute("activities", activities);
        model.addAttribute("tasks", tasks);
        model.addAttribute("weeks", weeks);
        model.addAttribute("currentMonth", currentMonth.getMonth());
        model.addAttribute("currentYear", currentMonth.getYear());
        model.addAttribute("prevMonth", prevMonth.atDay(1).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        model.addAttribute("nextMonth", nextMonth.atDay(1).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        return "calendar";
    }
}
