package com.example.Notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.Notes.databinding.ActivityNewitemssaveactivityBinding

class newitemssaveactivity : AppCompatActivity() {

  private lateinit var viewbind:ActivityNewitemssaveactivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_newitemssaveactivity)

        viewbind = ActivityNewitemssaveactivityBinding.inflate(layoutInflater)
        setContentView(viewbind.root)

        viewbind.saveButton.setOnClickListener {
            val st:String = viewbind.enterText.text.toString()

            val intent_ = Intent(this,MainActivity::class.java)
            intent_.putExtra("Note_data",st)
            startActivity(intent_)
        }
    }

}