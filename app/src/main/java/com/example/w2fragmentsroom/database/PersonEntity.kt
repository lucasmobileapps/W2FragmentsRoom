package com.example.w2fragmentsroom.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "persons")
data class PersonEntity(
    @PrimaryKey(autoGenerate = true) var id: Int?,
    @ColumnInfo(name = "person_name") var personName: String? = "Lucas",
    @ColumnInfo(name = "person_relation") var personRelation: String? = "Myself"
) {
    constructor(
        personName: String?,
        personRelation: String?
    ) : this(null, personName, personRelation)
}