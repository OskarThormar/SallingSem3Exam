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

    private List<Madplan> allMadplans = new ArrayList<>();

    public MadplanRepository() {
    }

    @Autowired
    public MadplanRepository(IngredientInterface ingredientInterface,
                             RecipeInterface recipeInterface,
                             MadplanInterface madplanInterface,
                             DayInterface dayInterface) {
        this.ingredientInterface = ingredientInterface;
        this.recipeInterface = recipeInterface;
        this.madplanInterface = madplanInterface;
        this.dayInterface = dayInterface;
    }

    public List<Recipe> getAllRecipes(){
        allRecipes = recipeInterface.findAll();

        return allRecipes;
    }

    public List<Ingredients> getAllIngredients(){
        allIngredients = ingredientInterface.findAll();

        return allIngredients;
    }

    public void saveMadplan(Madplan newMadplan){
        madplanInterface.save(newMadplan);
    }

    public void saveMadPlanDays(Madplan madplan){
        dayInterface.saveAll(madplan.getDays());
    }

    public List<Madplan> getAllMadplans(){
        allMadplans = madplanInterface.findAll();
        return allMadplans;
    }

    public double calculatePrice() {
        return 1;
    }

    public Madplan findNameById(int id) {
        return madplanList.get(id);
    }

    public void editMadplan(Madplan madplan) {

    }

    public void deleteMadplan(Madplan madplan) {

    }

}
