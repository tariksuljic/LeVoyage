package com.example.levoyage;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface UserDAO {

    @Insert
    public void addUser(User user);

    @Query("SELECT * FROM users")
    public List<User> getAllUsers();

    @Query("SELECT * FROM users WHERE user_id = :user_id LIMIT 1")
    public User getUser(int user_id);

    @Query("SELECT * FROM users WHERE username = :username LIMIT 1")
    public User getUserByUsername(String username);

    @Query("SELECT user_id FROM users WHERE username = :username LIMIT 1")
    public int getUserIDByUsername(String username);

    @Query("SELECT * FROM users WHERE email = :email LIMIT 1")
    public User getEmail(String email);

    @Query("SELECT * FROM users WHERE username = :username AND password = :password LIMIT 1")
    public User checkIfLoginLegit(String username, String password);

    @Delete
    public void deleteUser(User user);

    @Update
    public void updateUser(User user);

}
