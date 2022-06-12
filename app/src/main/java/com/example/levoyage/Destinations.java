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
    private String destination_price;
    private String phone_number;
    private String date;



    @Ignore
    public Destinations(int imageResId, String title, String description, String price, String phone_number,String date) {
        this.destination_price=price;
        this.imageResId = imageResId;
        this.destination_title = title;
        this.destination_description = description;
        this.phone_number = phone_number;
        this.date=date;
    }

    public Destinations(int destinationId,int imageResId, String title, String description, String price, String phone_number,String date) {
        this.destinationId=destinationId;
        this.destination_price=price;
        this.imageResId = imageResId;
        this.destination_title = title;
        this.destination_description = description;
        this.phone_number = phone_number;
        this.date=date;
    }



    public Destinations() {
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
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

    public String getDestination_price() {
        return destination_price;
    }

    public void setDestination_price(String destination_price) {
        this.destination_price = destination_price;
    }
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

