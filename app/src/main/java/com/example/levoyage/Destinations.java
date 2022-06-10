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

    public String getDestination_title() {
        return destination_title;
    }

    public void setDestination_title(String destination_title) {
        this.destination_title = destination_title;
    }

    public String getDestination_description() {
        return destination_description;
    }

    public void setDestination_description(String destination_description) {
        this.destination_description = destination_description;
    }

    public int getDestination_price() {
        return destination_price;
    }

    public void setDestination_price(int destination_price) {
        this.destination_price = destination_price;
    }
}

