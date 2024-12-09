package model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Madplan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany
    private List<Recipe> recipeList;
    private String name;
    private double price;
    /**
     Find ud af en anden måde at differentiere opskrifter mellem morgen, middag og aften.
     **/
    //private List[] days;

    public Madplan(int id, List<Recipe> recipeList, String name, double price) {
        this.id = id;
        this.recipeList = recipeList;
        this.name = name;
        this.price = price;
    }

    public Madplan() {

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
}
