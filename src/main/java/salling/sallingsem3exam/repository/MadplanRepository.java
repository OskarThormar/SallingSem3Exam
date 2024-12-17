package salling.sallingsem3exam.repository;

import org.springframework.stereotype.Repository;
import salling.sallingsem3exam.model.Madplan;
import salling.sallingsem3exam.model.Recipe;

import java.util.ArrayList;
import java.util.List;
@Repository
public class MadplanRepository {
    private Madplan madplan;
    private List<Madplan> madplanList;

    public MadplanRepository(Madplan madplan) {
        this.madplan = madplan;
    }

    public MadplanRepository() {
        madplanList = new ArrayList<>();
        addHardCodedMealPlan();
    }

    public double calculatePrice() {
        return 1;
    }

    public List<Madplan> getMadplan() {
        return madplanList;
    }

    public Madplan findNameById(int id) {
        return madplanList.get(id);
    }

    public void createMadplan(Madplan madplan) {

    }

    public void editMadplan(Madplan madplan) {

    }

    public void deleteMadplan(Madplan madplan) {

    }

    private void addHardCodedMealPlan() {
        RecipeRepository recipeRepository = new RecipeRepository();

        List<Recipe> recipesForWeek1 = new ArrayList<>();
        recipesForWeek1.add(recipeRepository.getRecipes().get(0));
        recipesForWeek1.add(recipeRepository.getRecipes().get(2));

        Madplan week1 = new Madplan(1, recipesForWeek1, "Uge 1 Madplan", 100);
        madplanList.add(week1);

        List<Recipe> recipesForWeek2 = new ArrayList<>();
        recipesForWeek2.add(recipeRepository.getRecipes().get(1));
        recipesForWeek2.add(recipeRepository.getRecipes().get(4));

        Madplan week2 = new Madplan(2, recipesForWeek2, "Uge 2 Madplan", 200);
        madplanList.add(week2);
    }

    public List<Recipe> getRecipesForMadplan(int madplanId) {
        for (Madplan madplan : madplanList) {
            if (madplan.getId() == madplanId) {
                return madplan.getRecipeList();
            }
        }
        return new ArrayList<>();
    }

    public double calculateTotalPriceForMadplan(int madplanId) {
        for (Madplan madplan : madplanList) {
            if (madplan.getId() == madplanId) {
                double totalPrice = 0;
                for (Recipe recipe : madplan.getRecipeList()) {
                    totalPrice += recipe.getPrice();
                }
                return totalPrice;
            }
        }
        return 0;
    }

}
