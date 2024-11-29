package salling.sallingsem3exam.model;

import java.util.List;

public class Madplan {
    private int id;
    private  Recipe[] mealTime = new Recipe[3];
    private String name;
    private double price;
    private List[] days;

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
    public void setDays(int days){
        this.days = new List[days];
    }

    public List[] getDays() {
        return days;
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
