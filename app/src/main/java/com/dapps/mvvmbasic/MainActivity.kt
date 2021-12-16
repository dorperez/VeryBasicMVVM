package com.dapps.mvvmbasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dapps.mvvmbasic.model.Character
import com.dapps.mvvmbasic.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val mainViewModel: MainViewModel by viewModels() // Making connection to the ViewModel so we can access it

        // Here we observe the data(watching the data) and see if its change.
        // If the data changed than we start the recyclerView to display the new Data.
        mainViewModel.getCharacters().observe(this, object : Observer<List<Character>> {
            override fun onChanged(t: List<Character>) {

                val recyclerView = findViewById<RecyclerView>(R.id.mainRecyclerView)
                recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 2)
                recyclerView.setHasFixedSize(true)
                recyclerView.adapter = MainRecyclerViewAdapter(t)

            }
        })



    }
}