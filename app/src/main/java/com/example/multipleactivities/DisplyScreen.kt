package com.example.multipleactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.system.exitProcess

class DisplyScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disply_screen)

        val arrayList = intent.extras?.getStringArrayList("data")
        var recyclerView = findViewById<RecyclerView>(R.id.rvMain)

        if(!arrayList.isNullOrEmpty()){
            recyclerView.adapter = RVadapter(arrayList)
            recyclerView.layoutManager = LinearLayoutManager(this)
        }
    }
    fun alert() {
        AlertDialog.Builder(this)
            .setTitle("Where Do You Want To Go?")
            .setMessage("Select Destination...")
            .setPositiveButton("Home") { _, _ ->
                startActivity(Intent(this, MainActivity::class.java))
            }.setNegativeButton("Exit") { _, _ ->
                exitProcess(1)
            }.show()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.goToMenu -> {
                alert()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}