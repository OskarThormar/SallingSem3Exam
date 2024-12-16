package salling.sallingsem3exam.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import salling.sallingsem3exam.model.Day;
import salling.sallingsem3exam.model.Ingredients;
import salling.sallingsem3exam.model.Madplan;
import salling.sallingsem3exam.model.Recipe;
import salling.sallingsem3exam.repository.DayInterface;
import salling.sallingsem3exam.repository.IngredientInterface;
import salling.sallingsem3exam.repository.MadplanInterface;
import salling.sallingsem3exam.repository.RecipeInterface;

import java.util.ArrayList;
import java.util.List;

public class InitData implements CommandLineRunner {

    private MadplanInterface madplanInterface;

    private RecipeInterface recipeInterface;

    private IngredientInterface ingredientsInterface;

    List<Recipe> morningRecipes = new ArrayList<>();
    List<Recipe> lunchRecipes = new ArrayList<>();
    List<Recipe> dinnerRecipes = new ArrayList<>();
    List<Recipe> allRecipes = new ArrayList<>();
    List<Ingredients> allIngredients = new ArrayList<>();

    private DayInterface dayRepository;

    @Override
    public void run(String... args) throws Exception {

        dayRepository.deleteAll();
        recipeInterface.deleteAll();
        ingredientsInterface.deleteAll();
        madplanInterface.deleteAll();

        // Ingredients creation
        Ingredients ing1 = new Ingredients("Tomato", 1.5, "kg", 2);
        Ingredients ing2 = new Ingredients("Cheese", 3.0, "kg", 1);
        Ingredients ing3 = new Ingredients("Bread", 2.0, "loaf", 1);
        Ingredients ing4 = new Ingredients("Lettuce", 1.0, "head", 1);
        Ingredients ing6 = new Ingredients("test1", 1.0, "head", 1);
        Ingredients ing7 = new Ingredients("test2", 1.0, "head", 1);


    }

    public void getRecipeList() {
        List<Recipe> recipeList = recipeInterface.findAll();
        for (Recipe recipe : recipeList) {
            System.out.println(recipe.toString());
        }
    }

    public void createDays(int userInput, Madplan madplan) {
        madplan = madplanInterface.save(madplan);

        int dayName = 0;

        for (int i = 0; i < userInput; i++) {
            Day day = new Day();
            day.setName("day" + dayName);
            dayName++;
            day.setMadplan(madplan);

            madplan.getDays().add(day);
        }

        for (Day day : madplan.getDays()) {
            if (day.getMorningRecipe() == null && !morningRecipes.isEmpty()) {
                day.setMorningRecipe(morningRecipes.get(0));
            }
            if (day.getEveningRecipe() == null && !dinnerRecipes.isEmpty()) {
                day.setEveningRecipe(dinnerRecipes.get(0));
            }
            if (day.getLunchRecipe() == null && !lunchRecipes.isEmpty()) {
                day.setLunchRecipe(lunchRecipes.get(0));
            }
        }
    }

    public void createDays1(int userInput, Madplan madplan) {
        int dayName = 0;

        // Create days and associate them with recipes
        for (int i = 0; i < userInput; i++) {
            Day day = new Day();
            day.setName("day" + dayName);
            dayName++;

            // Set the Madplan for this day
            day.setMadplan(madplan);

            // Here, we ensure that the recipes are correctly assigned
            if (!morningRecipes.isEmpty()) {
                day.setMorningRecipe(morningRecipes.get(i % morningRecipes.size()));
            }
            if (!lunchRecipes.isEmpty()) {
                day.setLunchRecipe(lunchRecipes.get(i % lunchRecipes.size()));
            }
            if (!dinnerRecipes.isEmpty()) {
                day.setEveningRecipe(dinnerRecipes.get(i % dinnerRecipes.size()));
            }

            // Add the day to Madplan
            madplan.getDays().add(day);
        }
    }

    public void compileData(){
//        allIngredients.add(ing1);
//        allIngredients.add(ing2);
//        allIngredients.add(ing3);
//        allIngredients.add(ing4);
//        allIngredients.add(ing6);
//        allIngredients.add(ing7);

        List<Ingredients> allIngredients2 = new ArrayList<>();
        List<Ingredients> allIngredients3 = new ArrayList<>();

      //  allIngredients2.add(ing6);
      //  allIngredients3.add(ing7);

        ingredientsInterface.saveAll(allIngredients);

        Recipe recipe1 = new Recipe("Cheese Sandwich", 5.5, "morning");
        Recipe recipe2 = new Recipe("Veggie Sandwich", 4.0,"lunch");
        Recipe recipe3 = new Recipe("non Veggie Sandwich", 4.0,"dinner");

        recipe1.setIngredientsList(allIngredients);
        recipe2.setIngredientsList(allIngredients2);
        recipe3.setIngredientsList(allIngredients3);

        allRecipes.add(recipe1);
        allRecipes.add(recipe2);
        allRecipes.add(recipe3);

        recipeInterface.saveAll(allRecipes);

        for(Recipe recipe : allRecipes){
            if(recipe.getMealTime().equalsIgnoreCase("morning")){
                morningRecipes.add(recipe);
            }
            if(recipe.getMealTime().equalsIgnoreCase("lunch")){
                lunchRecipes.add(recipe);
            }
            if(recipe.getMealTime().equalsIgnoreCase("dinner")){
                dinnerRecipes.add(recipe);
            }
        }

        // Madplan creation
        Madplan m1 = new Madplan();
        //m1.setRecipeList(new ArrayList<>());
        m1.setName("Simple Meal Plan");
        m1.setPrice(15.0);
        createDays(6, m1);
        dayRepository.saveAll(m1.getDays());
        madplanInterface.save(m1);

        System.out.println("Sample data initialized");

    }



}
