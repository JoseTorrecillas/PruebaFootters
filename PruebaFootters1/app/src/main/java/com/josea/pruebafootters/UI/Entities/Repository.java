package com.josea.pruebafootters.UI.Entities;

import android.os.Parcel;
import android.os.Parcelable;

public class Repository implements Parcelable {

    private String name;
    private String description;
    private String language;
    private int forks_count;
    private int stargazers_count;

    public Repository() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getForks_count() {
        return forks_count;
    }

    public void setForks_count(int forks_count) {
        this.forks_count = forks_count;
    }

    public int getStargazers_count() {
        return stargazers_count;
    }

    public void setStargazers_count(int stargazers_count) {
        this.stargazers_count = stargazers_count;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.language);
        dest.writeInt(this.forks_count);
        dest.writeInt(this.stargazers_count);
    }

    protected Repository(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
        this.language = in.readString();
        this.forks_count = in.readInt();
        this.stargazers_count = in.readInt();
    }

    public static final Parcelable.Creator<Repository> CREATOR = new Parcelable.Creator<Repository>() {
        @Override
        public Repository createFromParcel(Parcel source) {
            return new Repository(source);
        }

        @Override
        public Repository[] newArray(int size) {
            return new Repository[size];
        }
    };
}
