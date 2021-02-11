package com.example.simple.show.photos

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity() {

    private val tag = "TAG_Test"

    @Named("hi2")
    @Inject
    lateinit var strings : Set<String>

    @Inject
    lateinit var custom : CustomClass

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

        makeLogs()

        recyclerView.adapter = adapter

    }

    private fun cast() {

        recyclerView = findViewById(R.id.recycler_MainActivity_ShowPhotos)
        recyclerView.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
    }

    private fun makeLogs(){

        Log.i(tag,"show value intoSet : $strings")

    }
}