package com.example.levoyage;


import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "bookings")

public class Booking {

    @PrimaryKey(autoGenerate = true)
    private int bookingId;

    private int userId;
    private String totalPrice;
    private String destinationTitle;


    public Booking(int bookingId, int userId, String totalPrice,String destinationTitle) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.totalPrice = totalPrice;
        this.destinationTitle=destinationTitle;
    }

    @Ignore
    public Booking( int userId, String totalPrice,String destinationTitle) {

        this.userId = userId;
        this.totalPrice = totalPrice;
        this.destinationTitle=destinationTitle;
    }

    public String getDestinationTitle() {
        return destinationTitle;
    }

    public void setDestinationTitle(String destinationTitle) {
        this.destinationTitle = destinationTitle;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
}
