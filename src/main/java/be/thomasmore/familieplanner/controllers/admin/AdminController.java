package be.thomasmore.familieplanner.controllers.admin;

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
        return "calendar";
    }

    @GetMapping("nieuweactiviteit")
    public String nieuweActiviteitForm(Model model) {
        model.addAttribute("activiteit", new Activity());
        return "admin/nieuweactiviteit";
    }

    @PostMapping("nieuweactiviteit")
    public String activiteitToevoegen(@ModelAttribute Activity activity) {
        activiteitRepository.save(activity);
        return "redirect:/calendar";
    }

    @GetMapping("newtask")
    public String newTasksForm(Model model) {
        model.addAttribute("tasks", new Tasks());
        return "admin/newtask";
    }

    @PostMapping("newtask")
    public String addTasks(@ModelAttribute Tasks tasks) {
        taskRepository.save(tasks);
        return "redirect:/tasksoverview";
    }

    @GetMapping("/tasks/delete/{id}")
    public String deleteTask(@PathVariable("id") int id) {
        taskRepository.deleteById(id);
        return "redirect:/tasksoverview";
    }

    @GetMapping("/tasks/edit/{id}")
    public String editTaskForm(@PathVariable("id") int id, Model model) {
        Tasks task = taskRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ongeldig taak-ID: " + id));
        model.addAttribute("tasks", task);
        return "admin/edittask";
    }

    @PostMapping("/tasks/edit/{id}")
    public String updateTask(@PathVariable("id") int id, @ModelAttribute Tasks updatedTask) {
        updatedTask.setId(id);
        taskRepository.save(updatedTask);
        return "redirect:/tasksoverview";
    }
    @GetMapping("/activiteiten/edit/{id}")
    public String editActiviteitForm(@PathVariable("id") int id, Model model) {
        Activity activiteit = activiteitRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ongeldig activiteit-ID: " + id));
        model.addAttribute("activiteit", activiteit);
        return "admin/editactiviteit";
    }

    @PostMapping("/activiteiten/edit/{id}")
    public String updateActiviteit(@PathVariable("id") int id, @ModelAttribute Activity updated) {
        updated.setId(id);
        activiteitRepository.save(updated);
        return "redirect:/calendar";
    }

    @GetMapping("/activiteiten/delete/{id}")
    public String deleteActiviteit(@PathVariable("id") int id) {
        activiteitRepository.deleteById(id);
        return "redirect:/calendar";
    }

}
