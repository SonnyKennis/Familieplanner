package be.thomasmore.familieplanner.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JdbcUserDetailsManager jdbcUserDetailsManager;

    @GetMapping("/login")
    public String login(Model model, Principal principal) {
        // If the user is already logged in, redirect to the home page
        if (principal != null) return "redirect:/home";
        return "user/login";
    }

    @GetMapping("/logout")
    public String logout(Model model, Principal principal) {
        // If the user is not logged in, redirect to the home page
        if (principal == null) return "redirect:/home";
        return "user/logout";
    }

    @GetMapping("/register")
    public String register(Principal principal) {
        // If the user is already logged in, redirect to the home page
        if (principal != null) return "redirect:/home";
        return "user/register";
    }

    @PostMapping("/register")
    public String registerPost(Principal principal,
                               HttpServletRequest request,
                               @RequestParam String username,
                               @RequestParam String password,
                               @RequestParam String name,
                               @RequestParam String city,
                               @RequestParam Integer postalcode) throws ServletException {

        if (principal != null) return "redirect:/home";

        if (username == null || username.isBlank()) {
            return "redirect:/user/register?error=username";
        }
        if (jdbcUserDetailsManager.userExists(username)) {
            return "redirect:/user/register?error=username_exists";
        }

        // Encode the password before storing
        String encodedPassword = passwordEncoder.encode(password);

        // Create the new user
        UserDetails user = org.springframework.security.core.userdetails.User
                .builder()
                .username(username)
                .password(encodedPassword)
                .roles("USER") // Assign default role as USER
                .build();

        // Save the user using JdbcUserDetailsManager
        jdbcUserDetailsManager.createUser(user);

        // Redirect to the login page after successful registration
        return "redirect:/user/login?success=true";
    }
}