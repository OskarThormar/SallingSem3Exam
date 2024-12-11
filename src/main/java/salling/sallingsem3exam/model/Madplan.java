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

    @OneToMany
    List<Day> days = new ArrayList<>();

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
