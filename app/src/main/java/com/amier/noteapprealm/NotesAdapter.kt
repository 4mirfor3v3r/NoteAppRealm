package com.amier.noteapprealm

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.realm.RealmResults
import kotlinx.android.synthetic.main.notes_item.view.*

class NotesAdapter(private val context: Context, val notelist:RealmResults<Notes>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.notes_item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return notelist.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.item_id.text = notelist[position]!!.id.toString()
        holder.itemView.item_title.text = notelist[position]!!.title.toString()
        holder.itemView.item_description.text = notelist[position]!!.description.toString()
    }
    class ViewHolder(v:View?):RecyclerView.ViewHolder(v!!){
        val id = itemView.findViewById<TextView>(R.id.item_id)
        val title = itemView.findViewById<TextView>(R.id.item_title)
        val description = itemView.findViewById<TextView>(R.id.item_description)
    }

}