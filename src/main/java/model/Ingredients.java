package model;

public class Ingredients {
    private int id;
    private String name;
    private double price;
    private String unit;
    private int quantity;

    public Ingredients(String name, double price, String unit, int quantity) {
        this.name = name;
        this.price = price;
        this.unit = unit;
        this.quantity = quantity;
    }

    public Ingredients(String name, double price) {
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
