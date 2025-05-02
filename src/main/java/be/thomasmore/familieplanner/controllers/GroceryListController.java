package be.thomasmore.familieplanner.controllers;

import be.thomasmore.familieplanner.model.GroceryList;
import be.thomasmore.familieplanner.repository.GroceryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GroceryListController {

    @Autowired
    private GroceryRepository groceryRepository;

    @GetMapping("/grocery")
    public String grocery(Model model) {
        model.addAttribute("groceryList", groceryRepository.findAll());
        model.addAttribute("newItem", new GroceryList());
        return "grocery";
    }

    @PostMapping("/grocery")
    public String addItem(@ModelAttribute("newItem") GroceryList groceryList) {
        groceryRepository.save(groceryList);
        return "redirect:/grocery";
    }

    @PostMapping("/grocery/delete/{id}")
    public String deleteItem(@PathVariable Long id) {
        groceryRepository.deleteById(id);
        return "redirect:/grocery";
    }

    @PostMapping("/grocery/toggle/{id}")
    public String toggleDone(@PathVariable Long id) {
        groceryRepository.findById(id).ifPresent(item -> {
            item.setCompleted(!item.isCompleted());
            groceryRepository.save(item);
        });
        return "redirect:/grocery";
    }
}