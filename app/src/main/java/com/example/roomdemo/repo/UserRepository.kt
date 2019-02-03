package com.example.roomdemo.repo

import android.arch.lifecycle.LiveData
import android.support.annotation.WorkerThread
import com.example.roomdemo.db.users.User
import com.example.roomdemo.db.users.UserDao

/**
 * Created by uzafar
 * on 31 Jan, 2019
 * at 1:21 PM
 */

class UserRepository(private val userDao: UserDao) {
    val allUsers: LiveData<List<User>> = userDao.getAll()

    @WorkerThread
    suspend fun insert(user: User) {
        userDao.insertAll(user)
    }
}