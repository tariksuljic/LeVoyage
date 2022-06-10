package com.example.levoyage;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "destinations")
public class Destinations {

    @PrimaryKey(autoGenerate = true)
    private int destinationId;

    private int imageResId;
    private String destination_title;
    private String destination_description;
    private int destination_price;


    @Ignore
    public Destinations(int imageResId, String title, String description, int price) {
        this.destination_price=price;
        this.imageResId = imageResId;
        this.destination_title = title;
        this.destination_description = description;
    }

    public Destinations(int destinationId,int imageResId, String title, String description, int price) {
        this.destinationId=destinationId;
        this.destination_price=price;
        this.imageResId = imageResId;
        this.destination_title = title;
        this.destination_description = description;
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
        return destination_title;
    }

    public void setTitle(String title) {
        this.destination_title = title;
    }

    public String getDescription() {
        return destination_description;
    }

    public void setDescription(String description) {
        this.destination_description = description;
    }


    public int getPrice() {
        return destination_price;
    }

    public void setPrice(int price) {
        this.destination_price = price;
    }
}

