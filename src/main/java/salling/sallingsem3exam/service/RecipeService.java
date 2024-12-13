package salling.sallingsem3exam.service;

import org.springframework.stereotype.Service;
import salling.sallingsem3exam.repository.RecipeRepository;


@Service
public class RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public void addHardCodedRecipe() {

    }
}
