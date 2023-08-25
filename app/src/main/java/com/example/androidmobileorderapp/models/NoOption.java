package com.example.androidmobileorderapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class NoOption implements Parcelable {
    private long noOptionId;
    private String name;
    private double price;

    public NoOption(long noOptionId, String name, double price) {
        this.noOptionId = noOptionId;
        this.name = name;
        this.price = price;
    }

    protected NoOption(Parcel in) {
        noOptionId = in.readLong();
        name = in.readString();
        price = in.readDouble();
    }

    public static final Creator<NoOption> CREATOR = new Creator<NoOption>() {
        @Override
        public NoOption createFromParcel(Parcel in) {
            return new NoOption(in);
        }

        @Override
        public NoOption[] newArray(int size) {
            return new NoOption[size];
        }
    };

    public long getNoOptionId() {
        return noOptionId;
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
        dest.writeLong(this.noOptionId);
        dest.writeString(this.name);
        dest.writeDouble(this.price);
    }
}
