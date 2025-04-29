package be.thomasmore.familieplanner.admin;

import be.thomasmore.familieplanner.model.Activity;
import be.thomasmore.familieplanner.model.Tasks;
import be.thomasmore.familieplanner.repository.ActivityRepository;
import be.thomasmore.familieplanner.repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ActivityRepository activiteitRepository;

    @Autowired
    private TasksRepository taskRepository;

    @GetMapping("/activiteiten")
    public String lijstActiviteiten(Model model) {
        model.addAttribute("activiteiten", activiteitRepository.findAll());
        return "calendaroverview";
    }

    @GetMapping("nieuweactiviteit")
    public String nieuweActiviteitForm(Model model) {
        model.addAttribute("activiteit", new Activity());
        return "admin/nieuweactiviteit";
    }

    @PostMapping("nieuweactiviteit")
    public String activiteitToevoegen(@ModelAttribute Activity activity) {
        activiteitRepository.save(activity);
        return "redirect:/calendaroverview";
    }

    @GetMapping("newtask")
    public String newTasksForm(Model model) {
        model.addAttribute("tasks", new Tasks());
        return "admin/newtask";
    }

    @PostMapping("newtask")
    public String addTasks(@ModelAttribute Tasks tasks) {
        taskRepository.save(tasks);  // ✅ use the autowired instance
        return "redirect:/tasksoverview";  // also fix redirect path
    }

}
