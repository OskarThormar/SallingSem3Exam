package service;

import repository.RecipeRepository;



public class RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public void addHardCodedRecipe() {

    }
}
