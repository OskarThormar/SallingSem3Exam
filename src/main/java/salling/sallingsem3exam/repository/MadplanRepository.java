package salling.sallingsem3exam.repository;

import salling.sallingsem3exam.model.Madplan;
import salling.sallingsem3exam.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class MadplanRepository {
    private Madplan madplan;
    private List<Madplan> madplanList = new ArrayList<>();
    private List<Recipe> recipeList = new ArrayList<>();

    public MadplanRepository() {
    }

    public double calculatePrice() {
        return 1;
    }

    public List<Madplan> getMadplan() {
        Madplan test = new Madplan();
        test.setName("test");
        test.setDays(1);
        madplanList.add(test);

        return madplanList;
    }

    public Madplan findNameById(int id) {
        return madplanList.get(id);
    }

    public void createMadplan(Madplan madplan) {
        // Assign recipes to mealTime array
        for (Recipe recipe : recipeList) {
            if (recipe.getMealTime().equals("morning")) {
                madplan.getMealTimeList()[0] = recipe;
            } else if (recipe.getMealTime().equals("frokost")) {
                madplan.getMealTimeList()[1] = recipe;
            } else if (recipe.getMealTime().equals("aften")) {
                madplan.getMealTimeList()[2] = recipe;
            }
        }

        // Create lists for each day
        int numDays = madplan.getDays();
        madplan.setDays(numDays);

        for (int i = 0; i < numDays; i++) {
            List<Recipe> dailyRecipes = new ArrayList<>();
            dailyRecipes.add(madplan.getMealTimeList()[0]);
            dailyRecipes.add(madplan.getMealTimeList()[1]);
            dailyRecipes.add(madplan.getMealTimeList()[2]);
            madplan.getDays()[i] = dailyRecipes;
        }
    }

    public void editMadplan(Madplan madplan) {

    }

    public void deleteMadplan(Madplan madplan) {

    }

}
