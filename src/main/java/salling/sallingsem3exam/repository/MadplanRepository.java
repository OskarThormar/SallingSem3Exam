package salling.sallingsem3exam.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import salling.sallingsem3exam.model.Ingredients;
import salling.sallingsem3exam.model.Madplan;
import salling.sallingsem3exam.model.Recipe;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MadplanRepository {

    @Autowired
    IngredientInterface ingredientInterface;
    @Autowired
    RecipeInterface recipeInterface;
    @Autowired
    MadplanInterface madplanInterface;
    @Autowired
    DayInterface dayInterface;
    private List<Madplan> madplanList = new ArrayList<>();
    public List<Recipe> allRecipes = new ArrayList<>();
    private List<Ingredients> allIngredients = new ArrayList<>();

    public MadplanRepository() {
    }

    public List<Recipe> getAllRecipes(){
        allRecipes = recipeInterface.findAll();

        return allRecipes;
    }

    public List<Ingredients> getAllIngredients(){
        allIngredients = ingredientInterface.findAll();

        return allIngredients;
    }

    public double calculatePrice() {
        return 1;
    }

    public List<Madplan> getMadplan() {
        Recipe test1 = new Recipe("test1", "morning");
        Recipe test2 = new Recipe("test2", "evening");
        Recipe test3 = new Recipe("test3", "lunch");
        Recipe test4 = new Recipe("test4", "lunch");
        Recipe test5 = new Recipe("test5", "evening");
        Recipe test6 = new Recipe("test6", "morning");
        Recipe test7 = new Recipe("test7", "morning");

        allRecipes.add(test1);
        allRecipes.add(test2);
        allRecipes.add(test3);
        allRecipes.add(test4);
        allRecipes.add(test5);
        allRecipes.add(test6);
        allRecipes.add(test7);

        return madplanList;
    }

    public Madplan findNameById(int id) {
        return madplanList.get(id);
    }

    public void editMadplan(Madplan madplan) {

    }

    public void deleteMadplan(Madplan madplan) {

    }

}
