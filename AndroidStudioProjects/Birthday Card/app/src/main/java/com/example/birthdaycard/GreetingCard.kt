package com.example.birthdaycard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class GreetingCard : AppCompatActivity() {
    companion object{
        const val Name_Extra = "name_extra"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greeting_card)
        val name = intent.getStringExtra(Name_Extra)
        val greetText = findViewById<TextView>(R.id.BirthdayGreeting)
        greetText.text = "Happy Birthday\n$name!"
    }
}