package salling.sallingsem3exam.repository;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import salling.sallingsem3exam.model.Ingredients;
import salling.sallingsem3exam.model.Madplan;
import salling.sallingsem3exam.model.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Repository
public class Repository {

    @Autowired
    private IngredientInterface ingredientInterface;
    @Autowired
    private RecipeInterface recipeInterface;
    @Autowired
    private MadplanInterface madplanInterface;
    @Autowired
    private DayInterface dayInterface;
    @Autowired
    private EntityManager entityManager;
    private List<Madplan> madplanList = new ArrayList<>();
    public List<Recipe> allRecipes = new ArrayList<>();
    private List<Ingredients> allIngredients = new ArrayList<>();

    private List<Madplan> allMadplans = new ArrayList<>();

    public Repository() {
    }

    @Autowired
    public Repository(IngredientInterface ingredientInterface,
                      RecipeInterface recipeInterface,
                      MadplanInterface madplanInterface,
                      DayInterface dayInterface, EntityManager entityManager) {
        this.ingredientInterface = ingredientInterface;
        this.recipeInterface = recipeInterface;
        this.madplanInterface = madplanInterface;
        this.dayInterface = dayInterface;
        this.entityManager = entityManager;
    }

    public List<Recipe> getAllRecipes(){
        allRecipes = recipeInterface.findAll();

        return allRecipes;
    }

    public Madplan findMadPlanToUpdate(int ID){
        Optional<Madplan> madplan = madplanInterface.findById(ID);
        return madplan.orElseThrow(() -> new RuntimeException("Madplan not found"));
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

    public void removeMadplan(Madplan madplan){
        madplanInterface.delete(madplan);
    }

}
