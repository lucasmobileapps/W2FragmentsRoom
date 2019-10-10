package com.example.w2fragmentsroom.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PersonEntity::class], version = 2)
abstract class PersonDatabase: RoomDatabase(){
    abstract fun personDao(): PersonDAO
}