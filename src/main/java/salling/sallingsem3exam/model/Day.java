package salling.sallingsem3exam.model;

import jakarta.persistence.*;

@Entity
public class Day {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int ID;
    private String name;

    @ManyToOne
    @JoinColumn(name = "madplan_id")  // This is the foreign key column for Madplan
    private Madplan madplan;

    @ManyToOne
    private Recipe morningRecipe;

    @ManyToOne
    private Recipe lunchRecipe;

    @ManyToOne
    private Recipe eveningRecipe;

    public Day() {
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
