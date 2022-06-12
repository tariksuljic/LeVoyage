package com.example.levoyage;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "bookings" /*, foreignKeys = {
        @ForeignKey(entity = Destinations.class,
                    parentColumns = "destination_id",
                    childColumns = "b_destination_id"),
        @ForeignKey(entity = User.class,
                parentColumns = "user_id",
                childColumns = "b_user_id")

}*/


)
public class Booking {

    @PrimaryKey(autoGenerate = true)
//    @ColumnInfo(name = "booking_id")
    private int bookingId;

 //   @ColumnInfo(name = "b_destination_id")
    private int userId;

 //   @ColumnInfo(name="b_user_id")
 //   private int destinationId;
 //  private int bookedImageResId;
    private String totalPrice;


    public Booking(int bookingId, int userId, String totalPrice) {
        this.bookingId = bookingId;
        this.userId = userId;
        this.totalPrice = totalPrice;
    }

    @Ignore
    public Booking( int userId, String totalPrice) {

        this.userId = userId;
        this.totalPrice = totalPrice;
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
