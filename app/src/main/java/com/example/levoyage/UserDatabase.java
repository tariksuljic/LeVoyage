package com.example.levoyage;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase{

    private static UserDatabase INSTANCE = null;
    public abstract UserDAO myUserDAO();

    public static UserDatabase getDatabase(Context context)
    {
        if (INSTANCE == null)
        {
            INSTANCE = Room.databaseBuilder(context, UserDatabase.class, "user_database").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }



}
