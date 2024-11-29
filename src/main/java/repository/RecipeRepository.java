package repository;

import model.Ingredients;
import model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeRepository {
    private ArrayList<Recipe> recipes;
    private Recipe recipe;

    public RecipeRepository() {
        recipes = new ArrayList<>();
        addHardCodedRecipe();
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    private void addHardCodedRecipe() {
        List<Ingredients> spaghettiIngredients = new ArrayList<>();
        spaghettiIngredients.add(new Ingredients("Spaghetti", 10.0, "grams", 500));
        spaghettiIngredients.add(new Ingredients("Ground Beef", 50.0, "grams", 300));
        spaghettiIngredients.add(new Ingredients("Tomato Sauce", 20.0, "ml", 200));
        spaghettiIngredients.add(new Ingredients("Onion", 5.0, "pcs", 1));
        spaghettiIngredients.add(new Ingredients("Garlic", 3.0, "pcs", 2));
        recipes.add(new Recipe("Spaghetti Bolognese", spaghettiIngredients, 78.00));

        List<Ingredients> chickenSaladIngredients = new ArrayList<>();
        chickenSaladIngredients.add(new Ingredients("Chicken Breast", 45.0, "grams", 250));
        chickenSaladIngredients.add(new Ingredients("Lettuce", 15.0, "pcs", 1));
        chickenSaladIngredients.add(new Ingredients("Tomato", 10.0, "pcs", 2));
        chickenSaladIngredients.add(new Ingredients("Cucumber", 8.0, "pcs", 1));
        chickenSaladIngredients.add(new Ingredients("Dressing", 12.0, "ml", 50));
        recipes.add(new Recipe("Chicken Salad", chickenSaladIngredients, 90.00));

        List<Ingredients> pancakeIngredients = new ArrayList<>();
        pancakeIngredients.add(new Ingredients("Flour", 5.0, "grams", 200));
        pancakeIngredients.add(new Ingredients("Eggs", 3.0, "pcs", 2));
        pancakeIngredients.add(new Ingredients("Milk", 2.0, "ml", 300));
        pancakeIngredients.add(new Ingredients("Butter", 1.5, "grams", 50));
        pancakeIngredients.add(new Ingredients("Sugar", 1.0, "grams", 20));
        recipes.add(new Recipe("Pancakes", pancakeIngredients, 50.00));

        List<Ingredients> scrambledEggsIngredients = new ArrayList<>();
        scrambledEggsIngredients.add(new Ingredients("Eggs", 3.0, "pcs", 3));
        scrambledEggsIngredients.add(new Ingredients("Butter", 1.5, "grams", 20));
        scrambledEggsIngredients.add(new Ingredients("Salt", 0.5, "grams", 1));
        scrambledEggsIngredients.add(new Ingredients("Pepper", 0.5, "grams", 1));
        recipes.add(new Recipe("Scrambled Eggs", scrambledEggsIngredients, 25.00));

        List<Ingredients> grilledCheeseIngredients = new ArrayList<>();
        grilledCheeseIngredients.add(new Ingredients("Bread", 2.0, "slices", 2));
        grilledCheeseIngredients.add(new Ingredients("Cheese", 4.0, "grams", 50));
        grilledCheeseIngredients.add(new Ingredients("Butter", 1.5, "grams", 10));
        recipes.add(new Recipe("Grilled Cheese Sandwich", grilledCheeseIngredients, 20.00));

        List<Ingredients> caesarSaladIngredients = new ArrayList<>();
        caesarSaladIngredients.add(new Ingredients("Lettuce", 15.0, "pcs", 1));
        caesarSaladIngredients.add(new Ingredients("Chicken Breast", 45.0, "grams", 150));
        caesarSaladIngredients.add(new Ingredients("Croutons", 5.0, "grams", 50));
        caesarSaladIngredients.add(new Ingredients("Caesar Dressing", 20.0, "ml", 30));
        caesarSaladIngredients.add(new Ingredients("Parmesan Cheese", 10.0, "grams", 20));
        recipes.add(new Recipe("Caesar Salad", caesarSaladIngredients, 75.00));
    }
}
