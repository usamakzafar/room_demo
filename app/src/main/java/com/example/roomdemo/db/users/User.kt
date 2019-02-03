package com.example.roomdemo.db.users

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by uzafar
 * on 31 Jan, 2019
 * at 11:07 AM
 */

@Entity
data class User(
    @ColumnInfo(name = "first_name") var firstName: String?,
    @ColumnInfo(name = "last_name") var lastName: String?
) {
    @PrimaryKey(autoGenerate = true) var uid: Int = 0

    override fun toString(): String {
        return "ID: $uid, NAME: $firstName $lastName"
    }
}