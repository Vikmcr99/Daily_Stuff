package com.example.daily_stuff.Adapters

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.daily_stuff.Model.NotesClass
import com.example.daily_stuff.R
import kotlinx.android.synthetic.main.notes_itens.view.*
import kotlinx.android.synthetic.main.todo_itens.view.cbCheck

class AdapterNotes(private val notesList : MutableList<NotesClass>): RecyclerView.Adapter<AdapterNotes.NotesViewHolder>()

{
    class NotesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    private fun toggleStrikeThrough(tvNotesTitle: TextView, tvNotesDescriprion : TextView,isChecked: Boolean) {
        if(isChecked) {
            tvNotesTitle.paintFlags = tvNotesTitle.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            tvNotesDescriprion.paintFlags = tvNotesTitle.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            tvNotesTitle.paintFlags = tvNotesTitle.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            tvNotesDescriprion.paintFlags = tvNotesTitle.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    fun addNote(notes: NotesClass) {
        notesList.add(notes)
        notifyItemInserted(notesList.size - 1)
    }

    fun deleteNote()
    {
        notesList.removeAll {notes -> notes.isChecked }
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder
    {
        return  NotesViewHolder(LayoutInflater.from(parent.context).inflate(
            R.layout.notes_itens,
            parent,false))

    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int)
    {
        val currentNote = notesList[position]
        holder.itemView.tvtitleNote.text = currentNote.title
        holder.itemView.tvDescription.text = currentNote.description
        holder.itemView.cbCheck.isChecked = currentNote.isChecked
        toggleStrikeThrough(holder.itemView.tvtitleNote, holder.itemView.tvDescription,currentNote.isChecked)
        holder.itemView.cbCheck.setOnCheckedChangeListener{_,ischeckd -> toggleStrikeThrough(holder.itemView.tvtitleNote,holder.itemView.tvDescription, ischeckd)}
        currentNote.isChecked = !currentNote.isChecked
    }

    override fun getItemCount(): Int {
        return notesList.size
    }
}



