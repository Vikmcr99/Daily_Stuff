package com.example.daily_stuff.Views

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daily_stuff.databinding.ActivitySendToMailBinding

class SendToMail : AppCompatActivity() {

    lateinit var binding : ActivitySendToMailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySendToMailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnSend.setOnClickListener{

            val subject = binding.etSubject.text.toString()
            val message = binding.etMessage.text.toString()


            if(subject.isNotEmpty() && message.isNotEmpty()){
                val intent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:victor.robinson@al.infnet.edu.br")
                    putExtra(Intent.EXTRA_TEXT, message)
                    putExtra(Intent.EXTRA_SUBJECT, subject)

                    startActivity(intent)
                }


            }

        }

    }
}