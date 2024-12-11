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

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    private MadplanInterface madplanRepository;

    @Autowired
    private RecipeInterface recipeRepository;

    @Autowired
    private IngredientInterface ingredientsRepository;

    List<Recipe> morningRecipes = new ArrayList<>();
    List<Recipe> lunchRecipes = new ArrayList<>();
    List<Recipe> dinnerRecipes = new ArrayList<>();
    List<Recipe> allRecipes = new ArrayList<>();

    @Autowired
    private DayInterface dayRepository;

    @Override
    public void run(String... args) throws Exception {

        dayRepository.deleteAll();
        recipeRepository.deleteAll();
        ingredientsRepository.deleteAll();
        madplanRepository.deleteAll();

        // Ingredients creation
        Ingredients ing1 = new Ingredients("Tomato", 1.5, "kg", 2);
        Ingredients ing2 = new Ingredients("Cheese", 3.0, "kg", 1);
        Ingredients ing3 = new Ingredients("Bread", 2.0, "loaf", 1);
        Ingredients ing4 = new Ingredients("Lettuce", 1.0, "head", 1);

        ingredientsRepository.save(ing1);
        ingredientsRepository.save(ing2);
        ingredientsRepository.save(ing3);
        ingredientsRepository.save(ing4);

        List<Ingredients> allIngredients = ingredientsRepository.findAll();

        Recipe recipe1 = new Recipe("Cheese Sandwich", 5.5, "morning");
        Recipe recipe2 = new Recipe("Veggie Sandwich", 4.0,"lunch");
        Recipe recipe3 = new Recipe("non Veggie Sandwich", 4.0,"dinner");

        recipe1.setIngredientsList(allIngredients);
        recipe2.setIngredientsList(allIngredients);
        recipe3.setIngredientsList(allIngredients);


        recipeRepository.save(recipe1);
        recipeRepository.save(recipe2);
        recipeRepository.save(recipe3);

        allRecipes = recipeRepository.findAll();

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
        createDays1(6, m1);
        //m1.setAmountOfDays(7);

        // int var = 0;
        // for (int i = 0; i < userInput; i++) {
        //     Day day = new Day;
        //     day.setName("day" + var);
        //     var++;
        // }
        //
        // for(Day day : daysList){
        //     if(day.getMorning() == null){
        //         day.setMorning(morningList.get(randomInt));
        //     }
        //     if(day.getLunch())
        // }
//
//        List<String> days = new ArrayList<>();
//        days.add("morgenmad_1");
//        days.add("middag_1");
//        days.add("aften_1");
//        days.add("Dag_4");
//        days.add("Dag_5");
//        days.add("Dag_6");
//        days.add("Dag_7");
//
//        //m1.setDays(days); // Assign the list of days to Madplan
//
//        // Adding recipes to Madplan
//        m1.getRecipeList().add(recipe1);
//        m1.getRecipeList().add(recipe2);
//
//        madplanRepository.save(m1);
//
//        // Additional Madplan for demonstration
//        Madplan m2 = new Madplan();
//        m2.setRecipeList(new ArrayList<>());
//        m2.setName("Advanced Meal Plan");
//        m2.setPrice(30.0);
//        m2.setAmountOfDays(7);
//
//        // Adding recipes to Madplan
//        m2.getRecipeList().add(recipe1); // Cheese Sandwich
//        m2.getRecipeList().add(recipe2); // Veggie Sandwich

        //madplanRepository.save(m2);
        madplanRepository.save(m1);
        dayRepository.saveAll(m1.getDays());

        System.out.println("Sample data initialized");

    }

    public void getRecipeList() {
        List<Recipe> recipeList = recipeRepository.findAll();
        for (Recipe recipe : recipeList) {
            System.out.println(recipe.toString());
        }
    }

    public void createDays(int userInput, Madplan madplan) {
        int dayName = 0;

        for (int i = 0; i < userInput; i++) {
            Day day = new Day();
            day.setName("day" + dayName);
            dayName++;
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



}
