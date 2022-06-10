package com.example.levoyage;

import static android.icu.text.MessagePattern.ArgType.SELECT;

import androidx.room.Dao;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DestinationDAO {

    @Query("SELECT * FROM destinations")
    public List<Destinations> getAllDestinations();

    @Query("SELECT * FROM destinations WHERE destinationId = :destination_id LIMIT 1")
    public Destinations getDestination(int destination_id);
}
