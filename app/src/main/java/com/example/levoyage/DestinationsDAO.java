package com.example.levoyage;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface DestinationsDAO {

    @Insert
    public void addDestination(Destinations destination);

    @Query("SELECT * FROM destinations")
    public List<Destinations> getAllDestinations();

    @Query("SELECT * FROM destinations WHERE destination_id = :destination_id LIMIT 1")
    public Destinations getDestination(int destination_id);

    @Query("SELECT * FROM destinations WHERE destination_title = :destination_title LIMIT 1")
    public Destinations getDestinationByTitle(String destination_title);

    @Query("SELECT * FROM destinations WHERE phone_number = :phone_number LIMIT 1")
    public Destinations getPhoneNumber(String phone_number);

    @Delete
    public void deleteUser(Destinations destination);

    @Update
    public void updateUser(Destinations destination);

}
