package salling.sallingsem3exam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ID;
    private String name;

    @ManyToOne
    @JoinColumn(name = "madplan_id")  // This is the foreign key column for Madplan
    @JsonIgnore
    private Madplan madplan;

    @ManyToOne
    @JoinColumn(name = "morning_recipe_id")
    private Recipe morningRecipe;

    @ManyToOne
    @JoinColumn(name = "lunch_recipe_id")
    private Recipe lunchRecipe;

    @ManyToOne
    @JoinColumn(name = "evening_recipe_id")
    private Recipe eveningRecipe;

    private double fullPriceForDay;

    public Day() {
    }

    public double getFullPriceForDay() {
        return fullPriceForDay;
    }

    public void setFullPriceForDay(double fullPriceForDay) {
        this.fullPriceForDay = fullPriceForDay;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public Recipe getEveningRecipe() {
        return eveningRecipe;
    }

    public Recipe getLunchRecipe() {
        return lunchRecipe;
    }

    public Recipe getMorningRecipe() {
        return morningRecipe;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setEveningRecipe(Recipe eveningRecipe) {
        this.eveningRecipe = eveningRecipe;
    }

    public void setLunchRecipe(Recipe lunchRecipe) {
        this.lunchRecipe = lunchRecipe;
    }

    public void setMorningRecipe(Recipe morningRecipe) {
        this.morningRecipe = morningRecipe;
    }

    public Madplan getMadplan() {
        return madplan;
    }

    public void setMadplan(Madplan madplan) {
        this.madplan = madplan;
    }
}
