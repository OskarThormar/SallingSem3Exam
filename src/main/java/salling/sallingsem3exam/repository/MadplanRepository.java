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

    public void editMadplan(Madplan madplan) {

    }

    public void deleteMadplan(Madplan madplan) {

    }

}
