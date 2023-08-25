package com.example.androidmobileorderapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Item implements Parcelable {
    private String itemId;
    private String name;
    private String description;
    private double price;
    private int image;
    private ArrayList<Addon> addons = new ArrayList<>();
//    private ArrayList<NoOption> noOptions = new ArrayList<>();
//    private ArrayList<Group> groups = new ArrayList<>();

    public Item(String itemId, String name, String description, double price, int image) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.addons = new ArrayList<>();
    }

    public int getImage() {
        return image;
    }

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public ArrayList<Addon> getAddons() {
        return addons;
    }

    public void setAddons(ArrayList<Addon> addons) { this.addons = addons; }

    // http://sohailaziz05.blogspot.com/2012/04/passing-custom-objects-between-android.html
    // https://stacktuts.com/how-to-pass-parcelable-object-to-intent-and-use-getparcelable-method-of-bundle-in-android
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
//        dest.writeStringArray(new String[] { this.itemId, this.name, this.description, String.valueOf(this.price), String.valueOf(this.image)});
        dest.writeString(this.itemId);
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeDouble(this.price);
        dest.writeInt(this.image);
        dest.writeList(this.addons);
    }

    protected Item(Parcel in) {
        itemId = in.readString();
        name = in.readString();
        description = in.readString();
        price = in.readDouble();
        image = in.readInt();
        in.readList(addons, Addon.class.getClassLoader());

    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {

        @Override
        public Item createFromParcel(Parcel source) {
            return new Item(source);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}