package edu.iu.eebridge.finalproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema="flowers", name="flower")
public final class Flower {
    @Id
    private int id;
    private String name;
    private Type type;
    private Occasion occasion;
    private Color color;
    private float cost;

    public Flower() {
    }

    public Flower(int id, String name, Type type, Occasion occasion, Color color, float price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.occasion = occasion;
        this.color = color;
        this.cost = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Occasion getOccasion() {
        return occasion;
    }

    public void setOccasion(Occasion occasion) {
        this.occasion = occasion;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
}
