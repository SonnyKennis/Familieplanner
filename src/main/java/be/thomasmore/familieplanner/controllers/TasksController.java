package be.thomasmore.familieplanner.controllers;
import be.thomasmore.familieplanner.model.Tasks;
import be.thomasmore.familieplanner.repository.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class TasksController {


    @Autowired
    private TasksRepository tasksRepository;

    @GetMapping("/tasksoverview")
    public String calendarOverview(Model model) {
        Iterable<Tasks> tasks = tasksRepository.findAll();
        model.addAttribute("tasks", tasks);
        return "tasksoverview";
    }
}