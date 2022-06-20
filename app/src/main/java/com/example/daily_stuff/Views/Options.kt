package com.example.daily_stuff.Views

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daily_stuff.R
import com.example.daily_stuff.databinding.ActivityOptionsBinding


class Options : AppCompatActivity() {
    
    private lateinit var binding : ActivityOptionsBinding


    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOptionsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val todoFragment = TodoFragment()

        val notesFragment = NotesFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flfragment, todoFragment)
            commit()
        }


        binding.TodoIcon.setOnClickListener{
            val intent = Intent(this, TodoList::class.java)
            startActivity(intent)
        }
        
        binding.NotesIcon.setOnClickListener{
            val intent = Intent(this, Notes::class.java)
            startActivity(intent)
        }

       binding.btnTodo.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flfragment, todoFragment)
                commit()
            }
        }

        binding.btnNotes.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flfragment, notesFragment)
                commit()
            }
        }

        binding.btnShare.setOnClickListener{
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.setData(Uri.parse("mailto:victor.robinson@al.infnet.edu.br"))
            startActivity(Intent.createChooser(intent, "Feedback us"))
        }

    }}
