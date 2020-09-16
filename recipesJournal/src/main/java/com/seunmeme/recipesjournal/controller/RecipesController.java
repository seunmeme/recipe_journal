package com.seunmeme.recipesjournal.controller;

import com.seunmeme.recipesjournal.model.User;
import com.seunmeme.recipesjournal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecipesController {

    @Autowired
    private UserService userService;

    //Route for landing page
    @GetMapping("/")
    public String viewHomePage(Model model){

//        Set user so it can be accessed by login and register form
        User user = new User();
        model.addAttribute("user", user);

        return "index";
    }

    @GetMapping("/login")
    public String viewLoginPage(Model model){

//        Set user so it can be accessed by login and register form
        User user = new User();
        model.addAttribute("user", user);

        return "login";
    }

    @GetMapping("/recipes")
    public String viewDashboard(Model model){

//        Set user so it can be accessed by login and register form
        User user = new User();
        model.addAttribute("user", user);

        return "dashboard";
    }

    // Route for registration
    @PostMapping("/register")
    public String addUser(User user, Model model){
        return userService.register(user, model);
    }

    //Route for user login
    @PostMapping("/login")
    public String login(User user, Model model){
        return userService.login(user, model);
    }
}
