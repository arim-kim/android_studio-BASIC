package com.arim.diceapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.arim.diceapplication.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val leftSideDice = findViewById<ImageView>(R.id.leftside_dice)

        binding.startButton.setOnClickListener {


            var leftNum = Random.nextInt(1, 6).toString()
            var rightNum = Random.nextInt(1, 6).toString()

//          왼쪽 주사위 설정
            if (leftNum == "1") {
                binding.leftsideDice.setImageResource(R.drawable.dice_1)
            }
            if (leftNum == "2") {
                binding.leftsideDice.setImageResource(R.drawable.dice_2)
            }
            if (leftNum == "3") {
                binding.leftsideDice.setImageResource(R.drawable.dice_3)
            }
            if (leftNum == "4") {
                binding.leftsideDice.setImageResource(R.drawable.dice_4)
            }

            if (leftNum == "5") {
                binding.leftsideDice.setImageResource(R.drawable.dice_5)
            }
            if (leftNum == "6") {
                binding.leftsideDice.setImageResource(R.drawable.dice_6)
            }

//          오른쪽 주사위 설정

            if (rightNum == "1") {
                binding.rightsideDice.setImageResource(R.drawable.dice_1)
            }
            if (rightNum == "2") {
                binding.rightsideDice.setImageResource(R.drawable.dice_2)
            }
            if (rightNum == "3") {
                binding.rightsideDice.setImageResource(R.drawable.dice_3)
            }
            if (rightNum == "4") {
                binding.rightsideDice.setImageResource(R.drawable.dice_4)
            }

            if (rightNum == "5") {
                binding.rightsideDice.setImageResource(R.drawable.dice_5)
            }
            if (rightNum == "6") {
                binding.rightsideDice.setImageResource(R.drawable.dice_6)
            }


            if(rightNum == leftNum) {
                Toast.makeText(this, "double!", Toast.LENGTH_LONG).show()
            }
            }

        }
    }
