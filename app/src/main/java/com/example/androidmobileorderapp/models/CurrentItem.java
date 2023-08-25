package com.example.androidmobileorderapp.models;

import java.util.List;
import java.util.Observable;

public class CurrentItem extends Observable {
    private String itemId;
    private String description;
    private double price;
    private double totalPrice;
    private List<Addon> addons;

    public CurrentItem(String itemId, String description, double price, double totalPrice, List<Addon> addons) {
        this.itemId = itemId;
        this.description = description;
        this.price = price;
        this.totalPrice = totalPrice;
        this.addons = addons;
    }


}
