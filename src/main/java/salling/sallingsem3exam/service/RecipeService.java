package salling.sallingsem3exam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import salling.sallingsem3exam.model.Recipe;
import salling.sallingsem3exam.repository.RecipeRepository;
import salling.sallingsem3exam.repository.RecipeRepositoryInterface;

import java.util.List;

@Service
public class RecipeService {


    @Autowired
    private RecipeRepositoryInterface recipeRepositoryInterface;

    public List<Recipe> findAllRecipes() {
        return recipeRepositoryInterface.findAll();
    }
}
