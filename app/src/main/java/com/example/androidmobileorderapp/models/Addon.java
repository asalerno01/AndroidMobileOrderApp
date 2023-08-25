package com.example.androidmobileorderapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Addon implements Parcelable {
    private long addonId;
    private String name;
    private double price;

    public Addon(long addonId, String name, double price) {
        this.addonId = addonId;
        this.name = name;
        this.price = price;
    }

    public long getAddonId() {
        return addonId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeLong(this.addonId);
        dest.writeString(this.name);
        dest.writeDouble(this.price);
    }

    protected Addon(Parcel in) {
        this.addonId = in.readLong();
        this.name = in.readString();
        price = in.readDouble();
    }

    public static final Creator<Addon> CREATOR = new Creator<Addon>() {

        @Override
        public Addon createFromParcel(Parcel source) {
            return new Addon(source);
        }

        @Override
        public Addon[] newArray(int size) {
            return new Addon[size];
        }
    };
}
