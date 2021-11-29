package com.arim.wisesayingapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.arim.wisesayingapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var isDouble = false
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sentence = mutableListOf<String>()
        sentence.add("명언1")
        sentence.add("명언2")
        sentence.add("명언3")
        sentence.add("명언4")
        sentence.add("명언5")

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.listViewItem.setText(sentence.random())


        binding.backToMenu.setOnClickListener {
            val intent = Intent(this, SentenceActivity::class.java)
            startActivity(intent)
        }



    }


    override fun onBackPressed() {

        if (isDouble == true) {
            finish()
        }

        isDouble = true
        Toast.makeText(this, "종료 하시려면 더블클릭 하세요", Toast.LENGTH_SHORT).show()

        Handler().postDelayed(Runnable {
            isDouble = false

        },2000)


    }


}