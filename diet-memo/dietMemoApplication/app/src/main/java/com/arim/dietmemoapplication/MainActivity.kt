package com.arim.dietmemoapplication

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.util.*



class MainActivity : AppCompatActivity() {

    val dataModelList = mutableListOf<DataModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addMemo = findViewById<ImageView>(R.id.addMemo)
        // listview에 연결
        val list_container = findViewById<ListView>(R.id.main_list)
        val listview_adaptor = ListViewAdaptor(dataModelList)
        list_container.adapter = listview_adaptor

        // 데이터 베이스에 저장하기
        val database = Firebase.database
        val myRef = database.getReference("myMemo")

        myRef.child(Firebase.auth.currentUser!!.uid).addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                // 추가될때 마다 clear해주고 새로 연결
                dataModelList.clear()

                for(dataModel in snapshot.children) {
                    Log.d("Data", dataModel.toString())
                    dataModelList.add(dataModel.getValue(DataModel::class.java)!!) //우리가 만든 type인 DataModel로 들어오게 함
                }

                listview_adaptor.notifyDataSetChanged() // 비동기 방식 사용 -> 위에서 연결해줘도 밑에서 데이터를 빼오기 때문에 비동기 필요

                Log.d("DataModel", dataModelList.toString())

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })
        addMemo.setOnClickListener {

            // 다이얼로그 만들기 -> custom_dialog.xml 생성

            val mDialogView = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("운동 메모 다이얼로그")

            val mAlertDialog = mBuilder.show()
            var seletedDate = ""

            mAlertDialog.findViewById<Button>(R.id.date_select)?.setOnClickListener {

                val today = GregorianCalendar()
                val year = today.get(Calendar.YEAR)
                val month = today.get(Calendar.MONTH)
                val date = today.get(Calendar.DATE)


                val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener {
                    override fun onDateSet(
                        view: DatePicker?,
                        year: Int,
                        month: Int,
                        dayOfMonth: Int
                    ) {
                        Log.d("MainActivity", "${year}, ${month+1}, ${dayOfMonth}")
                        mAlertDialog.findViewById<Button>(R.id.date_select)?.setText("${year}. ${month+1}. ${dayOfMonth}")
                        // 여기서는 null 가능성을 위해 ?를 넣어줘야하지만 변수로 초기화 하고 setText해주면 그럴필요 없음

                        seletedDate = "${year}, ${month+1}, ${dayOfMonth}"

                    }
                }, year, month, date )
                dlg.show()

                val saveBtn = mAlertDialog.findViewById<Button>(R.id.saveBtn)
                saveBtn?.setOnClickListener {

                    Log.d("MainActivity", "클릭됨")
                    val memo = mAlertDialog.findViewById<EditText>(R.id.memoContent)?.text.toString()
                    // 저장할 데이터 모델
                    val model = DataModel(seletedDate, memo)

                    val database = Firebase.database
                    val myRef = database.getReference("myMemo").child(Firebase.auth.currentUser!!.uid)
                    // 모델을 저장함
                    myRef.push().setValue(model)
                    Log.d("MainActivity", "데이터 전송")

                    // 선택 -> 저장 -> 닫기
                    mAlertDialog.dismiss()

                }

            }


        }




    }


}