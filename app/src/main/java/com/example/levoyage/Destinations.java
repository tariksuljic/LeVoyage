package com.example.levoyage;

public class Destinations {
    private int imageResId;
    private String title;
    private String description;
    private int price;



    public Destinations(int imageResId, String title, String description, int price) {
        this.price=price;
        this.imageResId = imageResId;
        this.title = title;
        this.description = description;
    }

    public Destinations() {
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

