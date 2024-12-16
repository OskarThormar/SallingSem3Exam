package salling.sallingsem3exam.service;

import org.springframework.stereotype.Service;
import salling.sallingsem3exam.model.Ingredients;
import salling.sallingsem3exam.model.Recipe;
import salling.sallingsem3exam.repository.MadplanRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {
    private List<Ingredients> allIngredients = new ArrayList<>();
    private List<Recipe> allRecipes = new ArrayList<>();
    private MadplanRepository madplanRepository = new MadplanRepository();

    public RecipeService(){
    }




}
