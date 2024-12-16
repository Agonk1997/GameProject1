package com.example.gameproject

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.appcompat.widget.AppCompatButton

class DetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_detalis_activity)

        var image = findViewById<ImageView>(R.id.details_profile_image)
        var name = findViewById<TextView>(R.id.details_name)

        image.setImageResource(intent.getIntExtra("photo", 0))
        name.text = intent.getStringExtra("name")


        val goBackButton = findViewById<AppCompatButton>(R.id.backButton)
        goBackButton.setOnClickListener {
            finish()

        }
    }
}