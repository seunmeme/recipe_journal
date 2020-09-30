package com.seunmeme.recipesjournal.controller;

import com.seunmeme.recipesjournal.model.*;
import com.seunmeme.recipesjournal.service.RecipeService;
import com.seunmeme.recipesjournal.service.ReviewService;
import com.seunmeme.recipesjournal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    //Route for login page
    @GetMapping("/login")
    public String viewLoginPage(Model model){

//        Set user so it can be accessed by login and register form
        User user = new User();
        model.addAttribute("user", user);

        return "login";
    }

    //Route for displaying dashboard
    @GetMapping("/recipes")
    public String viewDashboard(Model model, HttpSession session){
        User user = (User)session.getAttribute("user");

        Recipe recipe = new Recipe();
        Iterable<Recipe> recipes = recipeService.getRecipes();
//        add recipes to the model
        model.addAttribute("recipes", recipes);
        model.addAttribute("user", user);

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
        Review review = new Review();

        Recipe recipe = recipeService.getRecipeById(Long.parseLong(recipeId));
        model.addAttribute("recipe", recipe);
        model.addAttribute("review", review);
        return "recipe-details";

    }

    //    Route for updating a recipe
    @PostMapping("/updateRecipe/{recipeId}")
    public String updateRecipe(HttpSession session, @PathVariable String recipeId, @RequestParam(value = "content") String content, @RequestParam(value = "title") String title) {
        User user = (User)session.getAttribute("user");
        Recipe theRecipe = recipeService.getRecipeById(Long.parseLong(recipeId));

        theRecipe.setContent(content);
        theRecipe.setTitle(title);
        theRecipe.setUser(user);
        recipeService.addRecipe(theRecipe);
        return "redirect:/recipes";

    }

    //    Route for deleting a recipe
    @GetMapping("/deleteRecipe/{recipeId}")
    public String deleteRecipe(@PathVariable String recipeId) {
        Recipe recipe = recipeService.getRecipeById(Long.parseLong(recipeId));

        recipeService.deleteRecipe(recipe);
        return "redirect:/recipes";

    }

    //    Route for adding an upvote
    @GetMapping("/upVote/{recipeId}")
    public String upVote(HttpSession session, @PathVariable String recipeId) {
        Recipe recipe = recipeService.getRecipeById(Long.parseLong(recipeId));

        UpVote vote = new UpVote();
        vote.setUser(recipe.getUser());
        recipe.getUpVotes().add(vote);

        recipeService.addRecipe(recipe);

        return "redirect:/recipes";

    }

    //    Route for adding a downvotevote
    @GetMapping("/downVote/{recipeId}")
    public String downVote(HttpSession session, @PathVariable String recipeId) {
        Recipe recipe = recipeService.getRecipeById(Long.parseLong(recipeId));

        DownVote downVote = new DownVote();
        downVote.setUser(recipe.getUser());
        recipe.getDownVotes().add(downVote);

        recipeService.addRecipe(recipe);

        return "redirect:/recipes";

    }

    //    Route for adding a review
    @PostMapping("/addReview/{recipeId}")
    public String addReview(HttpSession session, Review review, @PathVariable String recipeId) {
        Recipe recipe = recipeService.getRecipeById(Long.parseLong(recipeId));
        User user = (User)session.getAttribute("user");
        review.setUser(user);

        recipe.getReviews().add(review);
        recipeService.addRecipe(recipe);
        return "redirect:/recipes";

    }

}
