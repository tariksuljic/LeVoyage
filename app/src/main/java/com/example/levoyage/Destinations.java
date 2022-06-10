package com.example.levoyage;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "destinations")
public class Destinations {
    @PrimaryKey(autoGenerate = true)
    private int destinationId;

    private int imageResId;
    private String title;
    private String description;
    private int price;


    public Destinations(int destinationId, int imageResId, String title, String description, int price) {
        this.destinationId = destinationId;
        this.imageResId = imageResId;
        this.title = title;
        this.description = description;
        this.price = price;
    }
    @Ignore
    public Destinations(int imageResId, String title, String description, int price) {
        this.price=price;
        this.imageResId = imageResId;
        this.title = title;
        this.description = description;
    }

    public Destinations() {
    }

    public int getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

