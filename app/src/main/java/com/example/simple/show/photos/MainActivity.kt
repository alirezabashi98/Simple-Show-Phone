package com.example.simple.show.photos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var adapter: Adapter

    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cast()

        val component =
            DaggerAdapterComponent.builder().setApplication(application).build()
        component.inject(this)

        recyclerView.adapter = adapter

    }

    private fun cast() {

        recyclerView = findViewById(R.id.recycler_MainActivity_ShowPhotos)
        recyclerView.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
    }
}