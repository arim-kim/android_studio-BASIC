package com.arim.ddayapplication

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startBtn = findViewById<Button>(R.id.startDayBtn)
        val endBtn = findViewById<Button>(R.id.EnddayBtn)
        val DdayArea = findViewById<TextView>(R.id.Dday)



        var startDate = ""
        var endDate = ""

        var calendar_start = Calendar.getInstance()
        val calendar_end = Calendar.getInstance()

        startBtn.setOnClickListener {

            val today = GregorianCalendar()
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val day = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener{
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {

                    calendar_start.set(year, month+1, dayOfMonth)
                    startDate = year.toString() + (month+1).toString() + dayOfMonth.toString()
                    // startDate = "${year} + ${month} + ${day}
                    //Log.d("day", startDate)

                }

            }, year, month, day)
            dlg.show()
        }

        endBtn.setOnClickListener {

            val today = GregorianCalendar()
            val year = today.get(Calendar.YEAR)
            val month = today.get(Calendar.MONTH)
            val day = today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener{
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {

                    calendar_end.set(year, month+1, dayOfMonth)
                    endDate = year.toString() + (month+1).toString() + dayOfMonth.toString()

                    Log.d("day", endDate)

                    val Dday = TimeUnit.MILLISECONDS.toDays(calendar_end.timeInMillis - calendar_start.timeInMillis)

                    DdayArea.setText(Dday.toString())

                }

            }, year, month, day)
            dlg.show()
        }

    }

}