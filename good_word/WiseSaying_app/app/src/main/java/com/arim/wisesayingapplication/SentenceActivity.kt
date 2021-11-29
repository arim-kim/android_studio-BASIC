package com.arim.wisesayingapplication

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class SentenceActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sentence)

        val sentence = mutableListOf<String>()
        sentence.add("명언1")
        sentence.add("명언2")
        sentence.add("명언3")
        sentence.add("명언4")
        sentence.add("명언5")


        val sententAdapter = ListViewAdapter(sentence)

        val listView = findViewById<ListView>(R.id.sentence_menu)

        listView.adapter = sententAdapter
    }


}