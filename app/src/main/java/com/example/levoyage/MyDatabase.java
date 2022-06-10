package com.example.levoyage;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Destinations.class}, version = 2)
public abstract class MyDatabase extends RoomDatabase{

    private static MyDatabase INSTANCE = null;
    public abstract UserDAO myUserDAO();
    public abstract DestinationDAO myDestinationDAO();

    public static MyDatabase getDatabase(Context context)
    {
        if (INSTANCE == null)
        {
            INSTANCE = Room.databaseBuilder(context, MyDatabase.class, "my_database").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }



}
