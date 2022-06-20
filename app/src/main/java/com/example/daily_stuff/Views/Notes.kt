package com.example.daily_stuff.Views

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.daily_stuff.Adapters.AdapterNotes
import com.example.daily_stuff.Model.NotesClass
import com.example.daily_stuff.databinding.ActivityNotesBinding
import kotlinx.android.synthetic.main.activity_notes.*

class Notes : AppCompatActivity() {

    private lateinit var adapterNotes : AdapterNotes
    lateinit var binding : ActivityNotesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotesBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        adapterNotes = AdapterNotes(mutableListOf())
        rvNotesList.adapter = adapterNotes
        rvNotesList.layoutManager = LinearLayoutManager(this)

        btnAddNote.setOnClickListener{
            val notesTitle = etTitleNote.text.toString()
            val notesDescription = etNoteDescription.text.toString()

            if (notesTitle.isNotEmpty())
            {
                val note = NotesClass(notesTitle, notesDescription)
                adapterNotes.addNote(note)
            }
        }

        btnDeleteNote.setOnClickListener{
            adapterNotes.deleteNote()
        }

        binding.btnShareNote.setOnClickListener{
            val pmanager = packageManager
            val subject = binding.etTitleNote.text.toString()
            val message = binding.etNoteDescription.text.toString()

            if(subject.isNotEmpty() && message.isNotEmpty()){
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:victor.robinson@al.infnet.edu.br")
                    putExtra(Intent.EXTRA_TEXT, message)
                    putExtra(Intent.EXTRA_SUBJECT, subject)
                }

                if(intent.resolveActivity(pmanager)!= null)
                    startActivity(intent)

                else
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()

        }

    }
}

}