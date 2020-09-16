package com.seunmeme.recipesjournal.service;

import com.seunmeme.recipesjournal.model.Recipe;

public interface RecipeService {

    public void addRecipe(Recipe recipe);

    public Iterable<Recipe> getRecipes();

    public Recipe getPostById(Long id);
}
