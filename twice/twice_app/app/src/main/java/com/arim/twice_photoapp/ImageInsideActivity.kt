package com.arim.twice_photoapp

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ImageInsideActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_inside)

        val getData = intent.getStringExtra("data")
        val inside_Image = findViewById<ImageView>(R.id.inside_image)

        if(getData == "1"){
            inside_Image.setImageResource(R.drawable.member_1)
        }

        if(getData == "2"){
            inside_Image.setImageResource(R.drawable.member_2)
        }

        if(getData == "3"){
            inside_Image.setImageResource(R.drawable.member_3)
        }

        if(getData == "4"){
            inside_Image.setImageResource(R.drawable.member_4)
        }

        if(getData == "5"){
            inside_Image.setImageResource(R.drawable.member_5)
        }

        if(getData == "6"){
            inside_Image.setImageResource(R.drawable.member_6)
        }

        if(getData == "7"){
            inside_Image.setImageResource(R.drawable.member_7)
        }

        if(getData == "8"){
            inside_Image.setImageResource(R.drawable.member_8)
        }

        if(getData == "9"){
            inside_Image.setImageResource(R.drawable.member_9)
        }


    }



}