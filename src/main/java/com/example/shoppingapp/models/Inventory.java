package com.example.shoppingapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int ordered;
    private double price;
    private int available;

    public Inventory() {
        // Default constructor
    }

    public Inventory(int ordered, double price, int available) {
        this.ordered = ordered;
        this.price = price;
        this.available = available;
    }

    public int getOrdered() {
        return ordered;
    }

    public void setOrdered(int ordered) {
        this.ordered = ordered;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getQuantity() {
        return available; // Return the total quantity of available items in the inventory
    }
}
