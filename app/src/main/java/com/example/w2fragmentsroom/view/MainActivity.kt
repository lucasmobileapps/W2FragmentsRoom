package com.example.w2fragmentsroom.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.w2fragmentsroom.R
import com.example.w2fragmentsroom.adapter.PersonAdapter
import com.example.w2fragmentsroom.database.PersonDAO
import com.example.w2fragmentsroom.database.PersonDatabase
import com.example.w2fragmentsroom.database.PersonEntity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.entry_fragment_layout.*
import kotlinx.android.synthetic.main.recyclerview_fragment_layout.*

class MainActivity : AppCompatActivity(),
    FragmentEntry.FragmentEntryListener,
    FragmentRelation.FragmentRelationListener,
    FragmentRV.FragmentRVListener,
    PersonAdapter.PersonAdapterDelegate{

    private val fragmentEntry = FragmentEntry()
    private val fragmentRelation = FragmentRelation()
    private lateinit var fragmentRV: FragmentRV

    private lateinit var myDAO: PersonDatabase
    private var relationSelect : String = "Select your Relation Here"



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myDAO = Room.databaseBuilder(
            this,
            PersonDatabase::class.java,
            "person.db")
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build()
/*
        val person1  = PersonEntity("Charlie Brown", "Family")
        val person2  = PersonEntity("Ramsey Noah", "Friend")

        myDAO.personDao().insertAllPersons(person1, person2)


 */

        fragmentRV = FragmentRV()

        supportFragmentManager.beginTransaction()
            .add(R.id.entry_framelayout, fragmentEntry)
            .commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.RV_framelayout, fragmentRV)
            .commit()

        fragmentRV.setFragmentRVListener(this)
        fragmentRelation.setFragmentRelationListener(this)
        fragmentEntry.setFragmentEntryListener(this)



        clear_fragment_button.setOnClickListener{
            myDAO.personDao().deleteAllPersons()
            fragmentRV.notifyRV(mutableListOf())
        }
    }

    override fun onStart() {
        super.onStart()
        val personList = myDAO.personDao().getAllPersons()
        fragmentRV.notifyRV(personList)

    }

    override fun fragmentEntryRelationButtonPressed() {

        fragmentRelation.setFragmentRelationListener(this)
        supportFragmentManager.beginTransaction()
            .replace(R.id.relation_framelayout, fragmentRelation)
            .addToBackStack(null)
            .commit()
    }

    override fun fragmentEntryAddButtonPressed() {
        if (relationSelect == "Friend" || relationSelect == "Work" || relationSelect == "Family") {
            val newPerson = createGuest()
            myDAO.personDao().insertNewPerson(newPerson)
            var list = myDAO.personDao().getAllPersons()
            relationSelect = "Select your Relation Here"
            relation_edittext.text = relationSelect
            name_edittext.text.clear()
            fragmentRV.notifyRV(list)
        }
    }

    private fun createGuest():PersonEntity{
        return PersonEntity(null,
            name_edittext.text.toString(), relationSelect)
    }


    override fun fragmentWorkRelationButtonPressed() {
        relationSelect = "Work"
        fragmentEntry.fromRelationFrag(relationSelect)
    }

    override fun fragmentFamilyRelationButtonPressed() {
        relationSelect = "Family"
        fragmentEntry.fromRelationFrag(relationSelect)

    }

    override fun fragmentFriendRelationButtonPressed() {
        relationSelect = "Friend"
        fragmentEntry.fromRelationFrag(relationSelect)

    }

    override fun fragmentRVSelected() {
        Log.d("JOG", "RV Pressed")
    }

    override fun noteSelect(person: PersonEntity) {
        Log.d("JOG", "PRESSED")
    }
}