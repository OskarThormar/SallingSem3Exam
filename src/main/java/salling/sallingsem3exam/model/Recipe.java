package salling.sallingsem3exam.model;

import java.util.List;

public class Recipe {
    private int id;
    private String name;
    private String mealTime;
    private List<Ingredients> ingredientsList;
    private double price;

    public Recipe(String name, List<Ingredients> ingredientsList, double price) {
        this.name = name;
        this.ingredientsList = ingredientsList;
        this.price = price;
    }

    public Recipe(String name, String mealTime){
        this.name = name;
        this.mealTime = mealTime;
    }

    public String getMealTime() {
        return mealTime;
    }

    public void setMealTime(String mealTime) {
        this.mealTime = mealTime;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredients> getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(List<Ingredients> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
