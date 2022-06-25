package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setTitle("Recycler View Demo")
//        val songs:List<String> = listOf("Manish","Babli","Manish","Babli","Manish","Babli","Manish","Babli","Manish","Babli")

        val songsObject:MutableList<Model> = mutableListOf<Model>()
        songsObject.add(Model("Manish","I am Manish"))
        songsObject.add(Model("Babli","I am Babli"))
        songsObject.add(Model("Manish","I am Manish"))
        songsObject.add(Model("Babli","I am Babli"))
        songsObject.add(Model("Manish","I am Manish"))
        songsObject.add(Model("Babli","I am Babli"))
        songsObject.add(Model("Manish","I am Manish"))
        songsObject.add(Model("Babli","I am Babli"))
        songsObject.add(Model("Manish","I am Manish"))
        songsObject.add(Model("Babli","I am Babli"))
        songsObject.add(Model("Manish","I am Manish"))
        songsObject.add(Model("Babli","I am Babli"))
        songsObject.add(Model("Manish","I am Manish"))
        songsObject.add(Model("Babli","I am Babli"))
        songsObject.add(Model("Manish","I am Manish"))
        recView.adapter = MyAdapter(songsObject)
        recView.layoutManager = LinearLayoutManager(this)

    }
}