package com.arim.recyclerview_practice

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val list = mutableListOf<String>()

        list.add("A")
        list.add("B")
        list.add("C")

        val rv= findViewById<RecyclerView>(R.id.rv_container) // 리사이클러 뷰
        val rv_adapter = rvAdapter(list) // 어댑터

        rv.adapter = rv_adapter // 연결
        rv.layoutManager = LinearLayoutManager(this)

        rv_adapter.itemClicked = object : rvAdapter.ItemClicked {
            override fun onClick(view: View, position: Int) {

                Toast.makeText(baseContext, list[position], Toast.LENGTH_SHORT).show()
            }
        }

    }

}