package com.example.roomdemo.db.users

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

/**
 * Created by uzafar
 * on 31 Jan, 2019
 * at 11:12 AM
 */

@Dao
interface UserDao {
    @Query ("SELECT * FROM user")
    fun getAll(): LiveData<List<User>>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<User>

    @Query("SELECT * FROM USER WHERE first_name LIKE :first AND last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String) : User

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)

}