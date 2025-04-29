package be.thomasmore.familieplanner.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JdbcUserDetailsManager userDetailsManager;

    @GetMapping("/login")
    private String login(Model model, Principal principal) {
        if (principal != null) return "redirect:/home";
        return "user/login";
    }

    @GetMapping("/logout")
    private String logout(Model model, Principal principal) {
        if (principal == null) return "redirect:/home";
        return "user/logout";
    }

    @GetMapping("/register")
    public String register(Principal principal) {
        if (principal != null) return "redirect:/home";
        return "user/register";
    }
}
