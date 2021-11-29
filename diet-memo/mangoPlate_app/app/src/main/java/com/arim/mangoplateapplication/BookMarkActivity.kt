package com.arim.mangoplateapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class BookMarkActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private val contentModels = mutableListOf<DataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        auth = Firebase.auth

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_mark)

        val recyclerview = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = rvAdapter(this, contentModels)

        recyclerview.adapter = rvAdapter

        recyclerview.layoutManager = GridLayoutManager(this, 2)


        val database = Firebase.database
        val myBookmarkRef = database.getReference("bookmark_ref")


        myBookmarkRef
            .child(auth.currentUser?.uid.toString())
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {

                    for (dataModel in snapshot.children) {

//                        Toast.makeText(baseContext, "통신 완료", Toast.LENGTH_SHORT).show()
//                        Log.d("Datamodel", dataModel.toString())
                        contentModels.add(dataModel.getValue(DataModel::class.java)!!)

                    }
                    rvAdapter.notifyDataSetChanged()

                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("Bookmark", "dbError")
                }

            })






    }

}