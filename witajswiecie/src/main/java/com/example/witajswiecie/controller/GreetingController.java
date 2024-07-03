package com.example.witajswiecie.controller;

import com.example.witajswiecie.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class GreetingController {

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/greet")
    public String greetUser(@ModelAttribute User user, Model model) {
        int currentYear = LocalDate.now().getYear();
        int age = currentYear - user.getYearOfBirth();
        model.addAttribute("userName", user.getName());
        model.addAttribute("userAge", age);
        return "result";
    }
}
