package com.example.w2fragmentsroom.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.w2fragmentsroom.R
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.entry_fragment_layout.*
import kotlinx.android.synthetic.main.relation_fragment_layout.*

class FragmentRelation : Fragment() {

    private lateinit var fragmentRelationListener: FragmentRelationListener

    interface FragmentRelationListener {
        fun fragmentWorkRelationButtonPressed()
        fun fragmentFamilyRelationButtonPressed()
        fun fragmentFriendRelationButtonPressed()
    }

    fun setFragmentRelationListener(listener: FragmentRelationListener) {
        fragmentRelationListener = listener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.relation_fragment_layout, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        friend_edittext.setOnClickListener { _ ->

            fragmentRelationListener.fragmentFriendRelationButtonPressed()

        }
        work_edittext.setOnClickListener { _ ->

            fragmentRelationListener.fragmentWorkRelationButtonPressed()

        }
        family_edittext.setOnClickListener { _ ->

            fragmentRelationListener.fragmentFamilyRelationButtonPressed()

        }
    }
}