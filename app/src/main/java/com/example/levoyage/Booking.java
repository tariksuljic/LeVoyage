package com.example.levoyage;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "bookings", foreignKeys = {
        @ForeignKey(entity = Destinations.class,
                    parentColumns = "destination_id",
                    childColumns = "b_destination_id"),
        @ForeignKey(entity = User.class,
                parentColumns = "user_id",
                childColumns = "b_user_id")

}






)
public class Booking {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "booking_id")
    private int bookingId;

    @ColumnInfo(name = "b_destination_id")
    private int userId;

    @ColumnInfo(name="b_user_id")
    private int destinationId;

    private int bookedImageResId;
    private int numberOfPeople,totalPrice;

    public int getBookedImageResId() {
        return bookedImageResId;
    }

    public void setBookedImageResId(int bookedImageResId) {
        this.bookedImageResId = bookedImageResId;
    }

    @Ignore
    public Booking(int userId,int destinationId,int bookedImageResId,int numberOfPeople,int totalPrice){
        this.userId=userId;
        this.destinationId=destinationId;
        this.bookedImageResId=bookedImageResId;
        this.numberOfPeople=numberOfPeople;
        this.totalPrice=totalPrice;
    }

    public Booking(int bookingId, int userId, int destinationId, int bookedImageResId, int numberOfPeople, int totalPrice){
        this.bookingId=bookingId;
        this.userId=userId;
        this.destinationId=destinationId;
        this.bookedImageResId= bookedImageResId;
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
