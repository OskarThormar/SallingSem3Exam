package salling.sallingsem3exam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String mealTime;
    @ManyToMany
    @JsonIgnore
    private List<Ingredients> ingredientsList;
    private double price;

    public Recipe(String name, double price, String mealTime) {
        this.name = name;
        this.price = price;
        this.mealTime = mealTime;
    }

    public Recipe(String name, String mealTime){
        this.name = name;
        this.mealTime = mealTime;
    }

    public Recipe() {

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
