package com.example.levoyage;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "bookings")
public class Booking {

    @PrimaryKey(autoGenerate = true)
    private int bookingId;

    private int userId;
    private int destinationId;
    private int numberOfPeople;
    private int totalPrice;

    @Ignore
    public Booking(int userId,int destinationId,int numberOfPeople,int totalPrice){
        this.userId=userId;
        this.destinationId=destinationId;
        this.numberOfPeople=numberOfPeople;
        this.totalPrice=totalPrice;
    }

    public Booking(int bookingId,int userId,int destinationId,int numberOfPeople,int totalPrice){
        this.bookingId=bookingId;
        this.userId=userId;
        this.destinationId=destinationId;
        this.numberOfPeople=numberOfPeople;
        this.totalPrice=totalPrice;
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

    public int getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(int destinationId) {
        this.destinationId = destinationId;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
