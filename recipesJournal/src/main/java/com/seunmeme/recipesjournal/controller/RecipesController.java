package com.seunmeme.recipesjournal.controller;

import com.seunmeme.recipesjournal.model.Recipe;
import com.seunmeme.recipesjournal.model.User;
import com.seunmeme.recipesjournal.service.RecipeService;
import com.seunmeme.recipesjournal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class RecipesController {

    @Autowired
    private UserService userService;

    @Autowired
    private RecipeService recipeService;

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

        Recipe recipe = new Recipe();
        Iterable<Recipe> recipes = recipeService.getRecipes();
//        add recipes to the model
        model.addAttribute("recipes", recipes);
        model.addAttribute("recipe", recipe);

        return "dashboard";
    }

    // Route for registration
    @PostMapping("/register")
    public String addUser(User user, Model model, HttpSession session){
        return userService.register(user, model, session);
    }

    //Route for user login
    @PostMapping("/login")
    public String login(User user, Model model, HttpSession session){
        return userService.login(user, model, session);
    }

    //    Route for adding recipe
    @PostMapping("/addRecipe")
    public String addPost(Recipe recipe, HttpSession session) {
        User user = (User)session.getAttribute("user");

        recipe.setUser(user);
        recipeService.addRecipe(recipe);
        return "redirect:/recipes";

    }

    //    Route for getting a single recipe
    @GetMapping("/getRecipe/{recipeId}")
    public String getRecipe(@PathVariable String recipeId, Model model) {

        Recipe recipe = recipeService.getPostById(Long.parseLong(recipeId));
        model.addAttribute("recipe", recipe);
        return "recipe-details";

    }

//    //    Route for updating a post
//    @PostMapping("/updatePost/{postId}")
//    public String updatePost(HttpSession session, @PathVariable String postId, @RequestParam(value = "content") String content) {
//        User user = (User)session.getAttribute("user");
//        Post thePost = postService.getPostById(Long.parseLong(postId));
//
//        thePost.setContent(content);
//        thePost.setUser(user);
//        postService.addPost(thePost);
//        return "redirect:/home";
//
//    }
}
