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

    @Query("SELECT b.* from destinations d INNER JOIN bookings b on d.destination_id=b.b_destination_id INNER JOIN users u on b.b_user_id=u.user_id WHERE u.user_id=:id")
    public List<Booking> getBookingsByUserId(int id);

    @Query("SELECT b.* from destinations d INNER JOIN bookings b on d.destination_id=b.b_destination_id INNER JOIN users u on b.b_user_id=u.user_id WHERE u.user_id=:id")
    public List<Booking> getDestinationsTitle(int id);

    @Query("SELECT * FROM bookings")
    public List<Booking> getBookings();

    @Delete
    public void deleteBooking(Booking booking);

    @Update
    public void updateBooking(Booking booking);

}
