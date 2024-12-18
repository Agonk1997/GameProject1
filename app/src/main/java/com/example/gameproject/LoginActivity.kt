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
        setContentView(R.layout.login_activity)


        val dummyUsername = "testuser"
        val dummyPassword = "password123"


        val usernameEditText = findViewById<EditText>(R.id.username)
        val passwordEditText = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<AppCompatButton>(R.id.login)

        loginButton.setOnClickListener {

            val usernameInput = usernameEditText.text.toString()
            val passwordInput = passwordEditText.text.toString()


            if (usernameInput == dummyUsername && passwordInput == dummyPassword) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, GameListActivity::class.java))
            } else {
                Toast.makeText(this, "Invalid credentials, please try again.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
