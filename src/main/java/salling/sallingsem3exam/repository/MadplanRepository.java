package salling.sallingsem3exam.repository;

import salling.sallingsem3exam.model.Madplan;
import salling.sallingsem3exam.model.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MadplanRepository {
    private Madplan madplan;
    private List<Madplan> madplanList = new ArrayList<>();
    public List<Recipe> recipeList = new ArrayList<>();

    public MadplanRepository() {
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

        recipeList.add(test1);
        recipeList.add(test2);
        recipeList.add(test3);
        recipeList.add(test4);
        recipeList.add(test5);
        recipeList.add(test6);
        recipeList.add(test7);

        return madplanList;
    }

    public Madplan findNameById(int id) {
        return madplanList.get(id);
    }

    public void createMadplan(Madplan madplan) {
        Recipe[] mealTime = new Recipe[3];
        Random random = new Random();

        List<Recipe> morningRecipes = new ArrayList<>();
        List<Recipe> lunchRecipes = new ArrayList<>();
        List<Recipe> eveningRecipes = new ArrayList<>();


        int randomRecipe = random.nextInt(recipeList.size());


        for (Recipe recipe : recipeList) {
            if ("morning".equalsIgnoreCase(recipe.getMealTime())) {
                morningRecipes.add(recipe);
            } else if ("lunch".equalsIgnoreCase(recipe.getMealTime())) {
                lunchRecipes.add(recipe);
            } else if ("evening".equalsIgnoreCase(recipe.getMealTime())) {
                eveningRecipes.add(recipe);
            }
        }

        if (!morningRecipes.isEmpty()) {
            mealTime[0] = morningRecipes.get(random.nextInt(morningRecipes.size()));
        } else {
            throw new IllegalStateException("No recipes available for morning.");
        }

        if (!lunchRecipes.isEmpty()) {
            mealTime[1] = lunchRecipes.get(random.nextInt(lunchRecipes.size()));
        } else {
            throw new IllegalStateException("No recipes available for lunch.");
        }

        if (!eveningRecipes.isEmpty()) {
            mealTime[2] = eveningRecipes.get(random.nextInt(eveningRecipes.size()));
        } else {
            throw new IllegalStateException("No recipes available for evening.");
        }

        madplan.setMealTime(mealTime);

        int numDays = madplan.getRecipeListForMultipleDays().length;
        for (int i = 0; i < numDays; i++) {
            List<Recipe> dailyRecipes = new ArrayList<>();
            dailyRecipes.add(mealTime[0]); // Morning
            dailyRecipes.add(mealTime[1]); // Lunch
            dailyRecipes.add(mealTime[2]); // Evening
            madplan.getRecipeListForMultipleDays()[i] = dailyRecipes;
        }

        madplanList.add(madplan);
    }

    public void editMadplan(Madplan madplan) {

    }

    public void deleteMadplan(Madplan madplan) {

    }

}
