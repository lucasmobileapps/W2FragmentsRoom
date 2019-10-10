package com.example.w2fragmentsroom.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.w2fragmentsroom.R
import com.example.w2fragmentsroom.adapter.PersonAdapter
import com.example.w2fragmentsroom.database.PersonEntity
import kotlinx.android.synthetic.main.recyclerview_fragment_layout.*

class FragmentRV : Fragment(), PersonAdapter.PersonAdapterDelegate {

    private lateinit var fragmentRVListener: FragmentRVListener


    interface FragmentRVListener {
        fun fragmentRVSelected()
    }

    override fun noteSelect(note: PersonEntity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun setFragmentRVListener(listener: FragmentRVListener) {
        fragmentRVListener = listener
    }

    fun setUpRecyclerView(list: MutableList<PersonEntity>){
        fragment_recyclerview.adapter = PersonAdapter(list, this)
        fragment_recyclerview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)


        val itemDecorator = DividerItemDecoration(context, LinearLayout.VERTICAL)
        fragment_recyclerview.addItemDecoration(itemDecorator)
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.recyclerview_fragment_layout, container, false)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val personList = myDAO.getAllPersons()

        Log.d("JOG", "${personList}")

        setUpRecyclerView(personList)
    }
}