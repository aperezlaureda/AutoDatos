package com.example.autodatos.database


import androidx.room.*
import com.example.autodatos.entities.User


@Dao
interface UserDao {

    @Query("SELECT * FROM users ORDER BY id")
    fun fetchAllUsers(): MutableList<User?>?

    @Query("SELECT * FROM users WHERE id = :id")
    fun fetchUserById(id: Int): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User?)

    @Update
    fun updateUser(user: User?)

    @Delete
    fun delete(user: User?)
}
