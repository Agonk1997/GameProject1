package com.example.gameproject

import android.content.Intent
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.gameproject.adapters.GameAdapter
import com.example.gameproject.models.Game

class GameListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.game_list_layout)

        // Find the ListView in the layout
        val gameList = findViewById<ListView>(R.id.game_list)

        // Create a list of Game objects
        val games = mutableListOf(
            Game(R.drawable.game1, "Counter Strike 2", 1000),
            Game(R.drawable.game2, "Fortnite", 100),
            Game(R.drawable.game3, "League of Legends", 1040)
        )

        // Set up the custom adapter for the list
        val gameAdapter = GameAdapter(this, games)
        gameList.adapter = gameAdapter

        // Handle item click events
        gameList.setOnItemClickListener { _, _, position, _ ->
            val selectedGame = games[position]
            Toast.makeText(this, "${selectedGame.gameName} is clicked", Toast.LENGTH_LONG).show()

            // Navigate to DetailsActivity with extra data
            val intent = Intent(this, DetailsActivity::class.java).apply {
                putExtra("photo", selectedGame.photo)
                putExtra("name", selectedGame.gameName)
                putExtra("players", selectedGame.NrOfPlayers)
            }
            startActivity(intent)
        }
    }
}