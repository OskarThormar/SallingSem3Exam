package salling.sallingsem3exam.service;

import salling.sallingsem3exam.repository.RecipeRepository;



public class RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public void addHardCodedRecipe() {

    }
}
