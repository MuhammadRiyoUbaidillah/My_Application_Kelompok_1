package com.example.myapplication.data.dao

import androidx.room.*
import com.example.myapplication.data.entity.User

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getall(): List<User>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun getByIds(userIds: List<Int>): List<User>

    @Insert
    fun insertAll(vararg user: User)

    @Delete
    fun delete(user: User)

    @Query("SELECT * FROM user WHERE uid = :uid")
    fun get(uid: Int) : User

    @Update
    fun update(user: User)
}