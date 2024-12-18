package com.example.gameproject.adapters

import android.app.AlertDialog
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.gameproject.R
import com.example.gameproject.models.Game

class GameAdapter(private var context: Context, var list: MutableList<Game>) : BaseAdapter() {
    var layoutInflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


    override fun getView(position: Int, contextView: View?, parent: ViewGroup?): View {
        var rowView = layoutInflater.inflate(R.layout.game_item_layout, parent, false)

        var gamePhoto = rowView.findViewById<ImageView>(R.id.item_image)
        var gameName = rowView.findViewById<TextView>(R.id.item_name)
        var gameNrOfPlayers = rowView.findViewById<TextView>(R.id.item_age)

        gamePhoto.setImageResource(list[position].photo)
        gameName.text = list[position].gameName
        gameNrOfPlayers.text = list[position].NrOfPlayers.toString()

        var deleteButton = rowView.findViewById<ImageView>(R.id.deleteButton)
        deleteButton.setOnClickListener {

            showDeleteConfirmationDialog(position)
        }

        return rowView
    }

    fun removeGame(position: Int) {
        list.removeAt(position)
        notifyDataSetChanged()
    }

    private fun showDeleteConfirmationDialog(position: Int) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Delete Game")
            .setMessage("Are you sure you want to delete this game?")
            .setCancelable(false)
            .setPositiveButton("Yes") { dialog, id ->
                removeGame(position)
            }
            .setNegativeButton("No") { dialog, id ->
                dialog.dismiss()
            }

        val alert = builder.create()
        alert.show()
    }


}
