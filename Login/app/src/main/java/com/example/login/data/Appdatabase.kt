package com.example.login.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract  class Appdatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}