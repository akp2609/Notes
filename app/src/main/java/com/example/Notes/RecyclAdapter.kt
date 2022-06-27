package com.example.Notes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclAdapter(private val context: Context, private val listener: inotesadap): RecyclerView.Adapter<RecyclAdapter.NoteViewHolder>() {

    private val allnotes = ArrayList<Notes>()

    inner class NoteViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview){
        val textview: TextView = itemview.findViewById<TextView>(R.id.note_taking_recycle)
        val deletebtn: ImageView = itemview.findViewById<ImageView>(R.id.delete_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val viewHolder = NoteViewHolder(LayoutInflater.from(context).inflate(R.layout.add_note,parent,false))
        viewHolder.deletebtn.setOnClickListener{
         listener.onitemclicked(allnotes[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val curr = allnotes[position]
        holder.textview.text = curr.text
    }

    override fun getItemCount(): Int {
        return allnotes.size
    }

    fun updatelist(listnew : List<Notes>){
        allnotes.clear()
        allnotes.addAll(listnew)
        notifyDataSetChanged()
    }
}

interface inotesadap{
    fun onitemclicked(note:Notes)
}