package salling.sallingsem3exam.repository;

import salling.sallingsem3exam.model.Madplan;
import salling.sallingsem3exam.model.Recipe;

import java.util.ArrayList;
import java.util.List;

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
        for (Recipe recipe : recipeList) {
            if ("morning".equalsIgnoreCase(recipe.getMealTime())) {
                mealTime[0] = recipe;
            } else if ("lunch".equalsIgnoreCase(recipe.getMealTime())) {
                mealTime[1] = recipe;
            } else if ("evening".equalsIgnoreCase(recipe.getMealTime())) {
                mealTime[2] = recipe;
            }
        }

        for (int i = 0; i < mealTime.length; i++) {
            if (mealTime[i] == null) {
                throw new IllegalStateException("Missing recipe for " +
                        (i == 0 ? "morning" : i == 1 ? "lunch" : "evening") + " meal.");
            }
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
