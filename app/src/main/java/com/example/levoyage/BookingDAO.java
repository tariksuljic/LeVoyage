package com.example.levoyage;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface BookingDAO {

    @Insert
    public void addBooking(Booking booking);

    @Query("SELECT b.booking_id,b.b_user_id,b.b_destination_id,b.bookedImageResId,b.numberOfPeople,b.totalPrice  FROM destinations AS d,bookings AS b WHERE destination_id=b_destination_id AND b_user_id = :id ")
    public List<Booking> getBookingsByUserId(int id);

    @Query("SELECT * FROM bookings")
    public List<Booking> getBookings();

    @Delete
    public void deleteBooking(Booking booking);

    @Update
    public void updateBooking(Booking booking);

}
