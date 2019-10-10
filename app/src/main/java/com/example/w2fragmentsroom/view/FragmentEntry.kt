package com.example.w2fragmentsroom.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.w2fragmentsroom.R
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.entry_fragment_layout.*

class FragmentEntry : Fragment() {


    private lateinit var fragmentEntryListener: FragmentEntryListener

    interface FragmentEntryListener {
        fun fragmentEntryRelationButtonPressed()
        fun fragmentEntryAddButtonPressed()
    }

    fun setFragmentEntryListener(listener: FragmentEntryListener) {
        fragmentEntryListener = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return layoutInflater.inflate(R.layout.entry_fragment_layout, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        relation_edittext.setOnClickListener { _ ->

            fragmentEntryListener.fragmentEntryRelationButtonPressed()

        }
        fabAdd.setOnClickListener { _ ->

            fragmentEntryListener.fragmentEntryAddButtonPressed()

        }
    }
}