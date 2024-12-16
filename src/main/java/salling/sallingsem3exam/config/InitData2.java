package salling.sallingsem3exam.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import salling.sallingsem3exam.model.Ingredients;
import salling.sallingsem3exam.model.Recipe;
import salling.sallingsem3exam.repository.DayInterface;
import salling.sallingsem3exam.repository.IngredientInterface;
import salling.sallingsem3exam.repository.MadplanInterface;
import salling.sallingsem3exam.repository.RecipeInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class InitData2 implements CommandLineRunner {

    @Autowired
    private MadplanInterface madplanInterface;

    @Autowired
    private RecipeInterface recipeInterface;

    @Autowired
    private IngredientInterface ingredientsInterface;

    private DayInterface dayRepository;

    List<Recipe> morningRecipes = new ArrayList<>();
    List<Recipe> lunchRecipes = new ArrayList<>();
    List<Recipe> dinnerRecipes = new ArrayList<>();
    List<Recipe> allRecipes = new ArrayList<>();
    List<Ingredients> allIngredients = new ArrayList<>();

    @Override
    public void run(String... args) throws Exception {

        Random random = new Random();

        // Create 25 Ingredients
        for (int i = 1; i <= 25; i++) {
            Ingredients ingredient = new Ingredients(
                    "Ingredient " + i,            // Name
                    1.0 + random.nextDouble() * 10, // Random price between 1 and 10
                    "Unit " + i,                 // Unit
                    random.nextInt(10) + 1       // Random quantity between 1 and 10
            );
            allIngredients.add(ingredient);
        }

        // Save all ingredients to the repository
        ingredientsInterface.saveAll(allIngredients);

        // Generate Recipes for each mealtime
        String[] mealTimes = {"Morning", "Lunch", "Dinner"};
        for (String mealTime : mealTimes) {
            for (int i = 1; i <= 10; i++) {
                Recipe recipe = new Recipe(
                        mealTime + " Recipe " + i, // Name
                        mealTime                  // Mealtime
                );

                // Add random ingredients to the recipe
                List<Ingredients> recipeIngredients = new ArrayList<>();
                for (int j = 0; j < random.nextInt(5) + 3; j++) { // Each recipe gets 3 to 7 ingredients
                    recipeIngredients.add(allIngredients.get(random.nextInt(allIngredients.size())));
                }
                recipe.setIngredientsList(recipeIngredients);

                // Calculate price based on ingredients
                double price = recipeIngredients.stream().mapToDouble(Ingredients::getPrice).sum();
                recipe.setPrice(price);

                allRecipes.add(recipe);
            }
        }

        recipeInterface.saveAll(allRecipes);
    }
}
