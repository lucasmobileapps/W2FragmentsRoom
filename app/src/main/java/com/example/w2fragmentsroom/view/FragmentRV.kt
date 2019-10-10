package com.example.w2fragmentsroom.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.w2fragmentsroom.R

class FragmentRV : Fragment() {

    private lateinit var fragmentRVListener: FragmentRVListener

    interface FragmentRVListener {
        fun fragmentRVSelected()
    }

    fun setFragmentRVListener(listener: FragmentRVListener) {
        fragmentRVListener = listener
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

    }
}