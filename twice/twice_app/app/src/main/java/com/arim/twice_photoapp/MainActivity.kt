package com.arim.twice_photoapp

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val button1 = findViewById<ImageView>(R.id.TwiceImage_1)
        val button2 = findViewById<ImageView>(R.id.TwiceImage_2)
        val button3 = findViewById<ImageView>(R.id.TwiceImage_3)
        val button4 = findViewById<ImageView>(R.id.TwiceImage_4)
        val button5 = findViewById<ImageView>(R.id.TwiceImage_5)
        val button6 = findViewById<ImageView>(R.id.TwiceImage_6)
        val button7 = findViewById<ImageView>(R.id.TwiceImage_7)
        val button8 = findViewById<ImageView>(R.id.TwiceImage_8)
        val button9 = findViewById<ImageView>(R.id.TwiceImage_9)



        button1.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)
            intent.putExtra("data", "1") // data라는 박스 안에 1을 넣어보냄
            startActivity(intent)
        }

        button2.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)
            intent.putExtra("data", "2") // data라는 박스 안에 1을 넣어보냄
            startActivity(intent)
        }

        button3.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)
            intent.putExtra("data", "3") // data라는 박스 안에 1을 넣어보냄
            startActivity(intent)
        }

        button4.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)
            intent.putExtra("data", "4") // data라는 박스 안에 1을 넣어보냄
            startActivity(intent)
        }

        button5.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)
            intent.putExtra("data", "5") // data라는 박스 안에 1을 넣어보냄
            startActivity(intent)
        }

        button6.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)
            intent.putExtra("data", "6") // data라는 박스 안에 1을 넣어보냄
            startActivity(intent)
        }

        button7.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)
            intent.putExtra("data", "7") // data라는 박스 안에 1을 넣어보냄
            startActivity(intent)
        }

        button8.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)
            intent.putExtra("data", "8") // data라는 박스 안에 1을 넣어보냄

            startActivity(intent)
        }

        button9.setOnClickListener {
            val intent = Intent(this, ImageInsideActivity::class.java)
            intent.putExtra("data", "9") // data라는 박스 안에 1을 넣어보냄
            startActivity(intent)
        }



    }
}