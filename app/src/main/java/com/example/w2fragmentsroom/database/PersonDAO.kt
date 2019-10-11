package com.example.w2fragmentsroom.database

import androidx.room.*

@Dao
interface PersonDAO{
    @Query("SELECT * FROM my_persons")
    fun getAllPersons(): MutableList<PersonEntity>

    @Query("DELETE FROM my_persons")
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