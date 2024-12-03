package salling.sallingsem3exam.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Madplan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private double price;

    // Mapping a one-to-many relationship with Recipe
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "madplan_id")
    private List<Recipe> recipeList = new ArrayList<>();

    // Days as a list of recipes, assuming each day contains a recipe
    @ElementCollection
    private List<String> days = new ArrayList<>();

    // Constructors
    public Madplan(int id, List<Recipe> recipeList, String name, double price) {
        this.id = id;
        this.recipeList = recipeList;
        this.name = name;
        this.price = price;
    }

    public Madplan() {
    }

    // Getters and Setters
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

    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }

    public void setAmountOfDays(int days) {
        // Initialize a List of days with the size of 'days'
        this.days = new ArrayList<>(days);
    }
}
