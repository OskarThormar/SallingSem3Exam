package model;

import java.util.List;

public class Madplan {
    private int id;
    private List<Recipe> recipeList;
    private String name;
    private double price;
    private List[] days;

    public Madplan(int id, List<Recipe> recipeList, String name, double price) {
        this.id = id;
        this.recipeList = recipeList;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAmountOfDays(int days) {
        this.days = new List[days];
    }
}
