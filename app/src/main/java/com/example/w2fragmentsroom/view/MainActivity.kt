package com.example.w2fragmentsroom.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.w2fragmentsroom.R

class MainActivity : AppCompatActivity(),
    FragmentEntry.FragmentEntryListener,
    FragmentRelation.FragmentRelationListener,
    FragmentRV.FragmentRVListener{

    private val fragmentEntry = FragmentEntry()
    private val fragmentRelation = FragmentRelation()
    private val fragmentRV = FragmentRV()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.entry_framelayout, fragmentEntry)
            .commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.RV_framelayout, fragmentRV)
            .commit()

    }

    override fun fragmentEntryRelationButtonPressed() {
        val valueKey = "get_value"

        val bundle = Bundle()
        bundle.putString(valueKey, "Some text goes here.")
        fragmentRelation.arguments = bundle
        fragmentRelation.setFragmentRelationListener(this)
        supportFragmentManager.beginTransaction()
            .add(R.id.relation_framelayout, fragmentRelation)
            .addToBackStack(null)
            .commit()
    }

    override fun fragmentEntryAddButtonPressed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun fragmentWorkRelationButtonPressed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun fragmentFamilyRelationButtonPressed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun fragmentFriendRelationButtonPressed() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun fragmentRVSelected() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
