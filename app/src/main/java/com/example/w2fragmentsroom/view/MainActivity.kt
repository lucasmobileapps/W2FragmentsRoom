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

        val person1  = PersonEntity("Charlie Brown", "Family")
        val person2  = PersonEntity("Ramsey Noah", "Friend")
        val person3  = PersonEntity("Gordon Ramsey", "Work")
        val person4 = PersonEntity("Bill Gates", "Family")

        myDAO.personDao().insertAllPersons(person1, person2, person3, person4)

        val personList = myDAO.personDao().getAllPersons()
        Log.d("JOG", "In Main ${personList}")

        fragmentRV = FragmentRV(personList)


        supportFragmentManager.beginTransaction()
            .add(R.id.entry_framelayout, fragmentEntry)
            .commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.RV_framelayout, fragmentRV)
            .commit()


        fragmentRV.setFragmentRVListener(this)
        fragmentRelation.setFragmentRelationListener(this)
        fragmentEntry.setFragmentEntryListener(this)
    }


    override fun fragmentEntryRelationButtonPressed() {

        fragmentRelation.setFragmentRelationListener(this)
        supportFragmentManager.beginTransaction()
            .replace(R.id.relation_framelayout, fragmentRelation)
            .addToBackStack(null)
            .commit()
    }

    override fun fragmentEntryAddButtonPressed() {
        Log.d("JOG", "PRESSED")
        Log.d("JOG", "PRESSED")
    }

    override fun fragmentWorkRelationButtonPressed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun fragmentFamilyRelationButtonPressed() {
        Log.d("JOG", "PRESSED")

    }

    override fun fragmentFriendRelationButtonPressed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun fragmentRVSelected() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun noteSelect(note: PersonEntity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}