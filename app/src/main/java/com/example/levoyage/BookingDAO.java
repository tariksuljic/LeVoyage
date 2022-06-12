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

   @Query("SELECT * FROM bookings WHERE userId = :id")
   public List<Booking> getBookingsByUserId(int id);

    @Query("SELECT * FROM bookings")
    public List<Booking> getBookings();


    @Delete
    public void deleteBooking(Booking booking);

    @Update
    public void updateBooking(Booking booking);

}
