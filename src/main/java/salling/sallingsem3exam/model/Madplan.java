package salling.sallingsem3exam.model;

import java.util.List;

public class Madplan {
    private int id;
    private  Recipe[] mealTime;
    private String name;
    private double price;
    private int days;
    private List[] recipeListForMultipleDays = new List[days];


    public Madplan(int id, List<Recipe> recipeList, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Madplan(){

    }

    public int getId() {
        return id;
    }

    public Recipe[] getMealTimeList() {
        return mealTime;
    }
    public void setRecipeListForMultipleDays(int recipeListForMultipleDays){
        this.recipeListForMultipleDays = new List[recipeListForMultipleDays];
    }

    public void setMealTime(Recipe[] mealTime) {
        this.mealTime = mealTime;
    }

    public List[] getRecipeListForMultipleDays() {
        return recipeListForMultipleDays;
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

    public void setDays(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }
}
