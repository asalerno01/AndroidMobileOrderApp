package com.example.androidmobileorderapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Group implements Parcelable {
    private long groupId;
    private String name;
    private String description;
    private ArrayList<GroupOption> groupOptions;
    public Group(long groupId, String name, String description, ArrayList<GroupOption> groupOptions) {
        this.groupId = groupId;
        this.name = name;
        this.description = description;
        this.groupOptions = groupOptions;
    }

    protected Group(Parcel in) {
        groupId = in.readLong();
        name = in.readString();
        description = in.readString();
        groupOptions = in.createTypedArrayList(GroupOption.CREATOR);
    }

    public static final Creator<Group> CREATOR = new Creator<Group>() {
        @Override
        public Group createFromParcel(Parcel in) {
            return new Group(in);
        }

        @Override
        public Group[] newArray(int size) {
            return new Group[size];
        }
    };

    public long getGroupId() { return groupId; }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<GroupOption> getGroupOptions() {
        return groupOptions;
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeLong(groupId);
        dest.writeString(name);
        dest.writeList(this.groupOptions);
    }
}
