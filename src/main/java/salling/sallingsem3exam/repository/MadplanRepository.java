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
    }

    public void editMadplan(Madplan madplan) {

    }

    public void deleteMadplan(Madplan madplan) {

    }

}
