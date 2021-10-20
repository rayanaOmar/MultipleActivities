package com.example.multipleactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ConfirmScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_screen)

        val arrayList = intent.extras?.getStringArrayList("data")
        val textView: TextView = findViewById(R.id.tvData)

        for(i in arrayList!!){
            textView.text = "${textView.text} $i \n"
        }

        val confirmButton: Button = findViewById(R.id.confirmBtn)

        confirmButton.setOnClickListener {
            startActivity(Intent(this, DisplyScreen::class.java)
                .putExtra("data", arrayList))
        }
    }
}