package com.example.w2fragmentsroom.provider

import android.content.ContentProvider
import android.content.ContentValues
import android.content.UriMatcher
import android.database.Cursor
import android.net.Uri
import androidx.room.Room
import com.example.w2fragmentsroom.database.PersonDatabase

class PersonProvider : ContentProvider() {
    private val authority = "com.example.w2fragmentsroom.provider.PersonProvider"
    private val url = "content://$authority/persons"

    private val SINGLE_GUEST = 1
    private val ALL_GUESTS = 2

    private val uriMatcher = UriMatcher(UriMatcher.NO_MATCH)

    private var personDB: PersonDatabase? = null

    override fun insert(p0: Uri, p1: ContentValues?): Uri? {
        return null
    }

    override fun query(
        uri: Uri,
        projection: Array<out String>?,
        selection: String?,
        selectionArgs: Array<out String>?,
        sortOrder: String?
    ): Cursor? {
        var cursor: Cursor?

        when (uriMatcher.match(uri)) {
            ALL_GUESTS -> {
                cursor = personDB?.personDao()?.getAllPersonstoProvider()
            }
//            SINGLE_GUEST ->{
//            }
            else -> {
                cursor = null
            }

        }

        return cursor
    }

    override fun onCreate(): Boolean {

        uriMatcher.apply {
            addURI(authority, "persons", ALL_GUESTS)
            addURI(authority, "persons/#", SINGLE_GUEST)
        }

        context?.let { myContext ->
            personDB = Room.databaseBuilder(
                myContext,
                PersonDatabase::class.java,
                "person.db"
            )
                .allowMainThreadQueries()
                .build()
        }
        return (personDB != null)
    }

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int {
        return 0
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<out String>?): Int {
        return 0
    }

    override fun getType(p0: Uri): String? {
        return null
    }

}