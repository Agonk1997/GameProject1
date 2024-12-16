package com.example.gameproject

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity) // Ensure you have the correct layout

        // Dummy static user data
        val dummyUsername = "testuser"
        val dummyPassword = "password123"

        // Getting the input fields and button
        val usernameEditText = findViewById<EditText>(R.id.username)
        val passwordEditText = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<AppCompatButton>(R.id.login)

        loginButton.setOnClickListener {
            // Get the user inputs
            val usernameInput = usernameEditText.text.toString()
            val passwordInput = passwordEditText.text.toString()

            // Check if the entered credentials match the dummy data
            if (usernameInput == dummyUsername && passwordInput == dummyPassword) {
                // If match, proceed to next screen or show success
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                // You can proceed to another activity, for example:
                // startActivity(Intent(this, MainActivity::class.java))
                startActivity(Intent(this, GameListActivity::class.java))
            } else {
                // If no match, show an error
                Toast.makeText(this, "Invalid credentials, please try again.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
