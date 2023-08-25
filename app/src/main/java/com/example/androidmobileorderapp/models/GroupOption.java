package com.example.androidmobileorderapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class GroupOption implements Parcelable {
    private long groupOptionId;
    private String name;
    private double price;

    public GroupOption(long groupOptionId, String name, double price) {
        this.groupOptionId = groupOptionId;
        this.name = name;
        this.price = price;
    }

    public long getGroupOptionId() {
        return groupOptionId;
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
        dest.writeLong(this.groupOptionId);
        dest.writeString(this.name);
        dest.writeDouble(this.price);
    }

    protected GroupOption(Parcel in) {
        this.groupOptionId = in.readLong();
        this.name = in.readString();
        this.price = in.readDouble();
    }

    public static final Creator<GroupOption> CREATOR = new Creator<GroupOption>() {

        @Override
        public GroupOption createFromParcel(Parcel source) {
            return new GroupOption(source);
        }

        @Override
        public GroupOption[] newArray(int size) {
            return new GroupOption[size];
        }
    };
}
