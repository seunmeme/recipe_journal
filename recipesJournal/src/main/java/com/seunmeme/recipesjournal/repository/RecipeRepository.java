package com.seunmeme.recipesjournal.repository;

import com.seunmeme.recipesjournal.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
    Recipe findRecipeById(Long id);
}
