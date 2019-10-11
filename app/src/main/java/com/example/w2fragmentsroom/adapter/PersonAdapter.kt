package com.example.w2fragmentsroom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.w2fragmentsroom.R
import com.example.w2fragmentsroom.database.PersonEntity

class PersonAdapter(private val personadapterDelegate: PersonAdapterDelegate)
    : ListAdapter<PersonEntity, PersonAdapter.PersonViewHolder>(PersonDiffUtil()){
    interface  PersonAdapterDelegate{
        fun noteSelect(person: PersonEntity)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.person_item_view_layout, parent, false)
        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.apply {
            personNameTextView.text = getItem(position).personName
            personRelationTextView.text = getItem(position).personRelation
            viewGroup.setOnClickListener{
                personadapterDelegate.noteSelect(getItem(position))
            }
        }
    }
    class PersonViewHolder(view: View): RecyclerView.ViewHolder(view){
        val personNameTextView: TextView = view.findViewById(R.id.personName_textiew)
        val personRelationTextView: TextView = view.findViewById(R.id.personRelation_textiew)
        val viewGroup: ConstraintLayout = view.findViewById(R.id.person_itemview)

    }
}

class PersonDiffUtil : DiffUtil.ItemCallback<PersonEntity>(){
    override fun areItemsTheSame(oldItem: PersonEntity, newItem: PersonEntity): Boolean {
       return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PersonEntity, newItem: PersonEntity): Boolean {
        return oldItem.personName == newItem.personName && oldItem.personRelation == newItem.personRelation
    }
}
