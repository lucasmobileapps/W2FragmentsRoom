package com.example.w2fragmentsroom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.w2fragmentsroom.R
import com.example.w2fragmentsroom.database.PersonEntity

class PersonAdapter(private val personList: List<PersonEntity>, private val personadapterDelegate: PersonAdapterDelegate) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {
    interface  PersonAdapterDelegate{
        fun noteSelect(note: PersonEntity)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.person_item_view_layout, parent, false)
        return PersonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.apply {
            personNameTextView.text = personList.get(position).personName
            personRelationTextView.text = personList.get(position).personRelation
            viewGroup.setOnClickListener{
                personadapterDelegate.noteSelect(personList.get(position))
            }
        }
    }
    class PersonViewHolder(view: View): RecyclerView.ViewHolder(view){
        val personNameTextView: TextView = view.findViewById(R.id.personName_textiew)
        val personRelationTextView: TextView = view.findViewById(R.id.personRelation_textiew)
        val viewGroup: ConstraintLayout = view.findViewById(R.id.person_itemview)

    }
}
