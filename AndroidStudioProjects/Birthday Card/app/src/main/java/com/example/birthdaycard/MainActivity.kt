package com.example.birthdaycard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

//import android.widget.Button
//import android.widget.EditText
//import android.widget.Toast

class MainActivity : AppCompatActivity() {

//    lateinit var createBtn : Button
    lateinit var editName : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        createBtn = findViewById(R.id.createBtn)
        editName = findViewById(R.id.editName)
    }

    fun createCard(view: View) {
        val name =  editName.editableText.toString()
        val intent = Intent(this,GreetingCard::class.java)
        intent.putExtra(GreetingCard.Name_Extra,name)
        startActivity(intent)
    }


}
