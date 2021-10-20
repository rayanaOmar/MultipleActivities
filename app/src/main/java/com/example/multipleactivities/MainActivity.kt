package com.example.multipleactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var name : EditText
    lateinit var location: EditText
    lateinit var mobile: EditText
    lateinit var eMail: EditText

    lateinit var singUp: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        name = findViewById(R.id.nameEditText)
        location = findViewById(R.id.locationEditText)
        mobile = findViewById(R.id.mobileEditText)
        eMail = findViewById(R.id.mailEditText)
        singUp = findViewById(R.id.button)

        singUp.setOnClickListener {
            if(!findViewById<CheckBox>(R.id.checkBox).isChecked){
                Toast.makeText(applicationContext, "Agree", Toast.LENGTH_LONG).show()
            }else{
                startActivity(Intent(this, ConfirmScreen::class.java)
                    .putExtra("data", arrayListOf(
                        name.text.toString(),
                        location.text.toString(),
                        mobile.text.toString(),
                        eMail.text.toString()
                    )))
            }
        }
    }
}