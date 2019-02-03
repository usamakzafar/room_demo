package com.example.roomdemo.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.example.roomdemo.db.users.AppDatabase
import com.example.roomdemo.db.users.User
import com.example.roomdemo.repo.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

/**
 * Created by uzafar
 * on 31 Jan, 2019
 * at 1:26 PM
 */

class UsersViewModel(application: Application) : AndroidViewModel(application) {
    private val userRepository: UserRepository
    val allUsers: LiveData<List<User>>
    private val parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Main
    private val scope = CoroutineScope(coroutineContext)

    init {
        val dao = AppDatabase.getDatabase(application, scope).userDao()
        userRepository = UserRepository(dao)
        allUsers = dao.getAll()
    }

    fun insert(user: User) = scope.launch(Dispatchers.IO) {
        userRepository.insert(user)
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }
}