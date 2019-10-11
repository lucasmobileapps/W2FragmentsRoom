package com.example.w2fragmentsroom.database

import android.database.Cursor
import androidx.room.*

@Dao
interface PersonDAO{
    @Query("SELECT * FROM persons")
    fun getAllPersons(): MutableList<PersonEntity>

    @Query("SELECT * FROM persons")
    fun getAllPersonstoProvider(): Cursor

    @Query("DELETE FROM persons")
    fun deleteAllPersons(): Int

    @Delete
    fun deletePerson(personEntity: PersonEntity)

    @Insert
    fun insertNewPerson(newPerson: PersonEntity)


    @Update
    fun updatePerson(personEntity: PersonEntity)

    @Insert
    fun insertAllPersons(vararg personEntity: PersonEntity)
}