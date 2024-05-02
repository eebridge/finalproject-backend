package edu.iu.eebridge.finalproject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema="flowers",name="orders")
public final class Order {
    @Id
    @GeneratedValue
    private int id;
    private String username;
    private int flowerId;
    private String recipientName;
    private float totalCost;

    public Order() {
    }

    public Order(int id, String username, int flowerId, String recipientName, float totalCost) {
        this.id = id;
        this.username = username;
        this.flowerId = flowerId;
        this.recipientName = recipientName;
        this.totalCost = totalCost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getFlowerId() {
        return flowerId;
    }

    public void setFlowerId(int flowerId) {
        this.flowerId = flowerId;
    }

    public String getRecipientName() {
        return recipientName;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(float totalCost) {
        this.totalCost = totalCost;
    }

}
